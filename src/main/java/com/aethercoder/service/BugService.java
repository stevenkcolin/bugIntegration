package com.aethercoder.service;

import com.aethercoder.constants.PMContants;
import com.aethercoder.dao.BugDao;
import com.aethercoder.dao.BuildDao;
import com.aethercoder.entity.Bug;
import com.aethercoder.entity.Build;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by hepengfei on 05/12/2017.
 */
@Service
public class BugService {

    @Autowired
    private BuildDao buildDao;

    @Autowired
    private BugDao bugDao;

    public Bug createBugs(Map dataMap) {
        Map appMap = (Map)dataMap.get("app");
        List tagsList = (List)dataMap.get("tags");
        Map tagMap = (Map)tagsList.get(0);
        Map reporterMap = (Map)dataMap.get("reporter");
        Map issueMap = (Map)dataMap.get("issue");

        String version = (String)appMap.get("version");
        Long appId = (Long)appMap.get("id");
        String appName = (String)appMap.get("name");

        Map assigneeMap = (Map)tagMap.get("assignee");
        String assigneeName = (String)assigneeMap.get("nickname");
        Long tagId = (Long)tagMap.get("id");

        String description = (String)tagMap.get("description");
        Integer priority = (Integer)tagMap.get("priority");

        String reporterName = (String)reporterMap.get("nickname");

        String title = (String)issueMap.get("description");
        if (title == null || title.equals("")) {
            title = description;
        }
        Long issueId = (Long)issueMap.get("id");
        Long createTimeL = new Long((Integer)issueMap.get("create_time")) * 1000;
        Date createTime = new Date(createTimeL);

        Bug bug = new Bug();
        bug.setProduct(PMContants.QBAO_PRODUCT_ID);
        bug.setProject(PMContants.QBAO_PROJECT_MAP.get(appName));
        bug.setTitle(title);
        bug.setSeverity(PMContants.SEVERITY_MAP.get(priority).byteValue());
        bug.setOpenedBy(reporterName);
        bug.setOpenedDate(createTime);
        bug.setAssignedTo(PMContants.QBAO_ASSIGNEE_MAP.get(appName));
        bug.setOpenedBuild(checkVersion(version, bug.getProduct(), bug.getProject()).toString());
        bug.setConfirmed(false);
        bug.setAssignedDate(createTime);

        description += PMContants.DESCRIPTION_URL;
        description = StringUtils.replace(description, "{appId}", appId.toString());
        description = StringUtils.replace(description, "{tagId}", tagId.toString());
        description = StringUtils.replace(description, "{issueId}", issueId.toString());
        bug.setSteps(description);

        Bug pbug = bugDao.save(bug);
        return pbug;
    }

    private Integer checkVersion(String version, Integer productId, Integer projectId) {
        List<Build> buildList = buildDao.findBuildsByNameAndProductAndProject(version, productId, projectId);
        if (buildList != null && !buildList.isEmpty()) {
            return buildList.get(0).getId();
        }
        Build build = new Build();
        build.setName(version);
        build.setProduct(productId);
        build.setProject(projectId);
        build.setScmPath("");
        build.setFilePath("");
        build.setDate(new Date());
        build.setStories("");
        build.setBugs("");
        build.setDesc("");
        Build pBuild = buildDao.save(build);
        return pBuild.getId();
    }
}
