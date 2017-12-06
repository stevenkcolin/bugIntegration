package com.aethercoder.controller;

import com.aethercoder.entity.Bug;
import com.aethercoder.service.BugService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by hepengfei on 04/12/2017.
 */
@RestController
@RequestMapping(value = "zentao", produces = "application/json")
public class ZentaoController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BugService bugService;

    @RequestMapping(value = "/createAccount", method = RequestMethod.POST, consumes = "application/json")
    public Bug createBugFromBugtags(@RequestBody Map bugDetail) throws Exception {
        Map dataMap = (Map)bugDetail.get("data");
        logger.info("Input json: " + new ObjectMapper().writeValueAsString(bugDetail));
        return bugService.createBugs(dataMap);
    }
}
