package com.aethercoder.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hepengfei on 05/12/2017.
 */
public class PMContants {
    public static Map<String, Integer> QBAO_PROJECT_MAP;
    public static Map<Integer, Integer> SEVERITY_MAP;
    public static Map<String, String> QBAO_ASSIGNEE_MAP;
    static {
        QBAO_PROJECT_MAP = new HashMap<>();
        QBAO_PROJECT_MAP.put("qbao-iOS", 5);
        QBAO_PROJECT_MAP.put("qbao-Android", 4);

        QBAO_ASSIGNEE_MAP = new HashMap<>();
        QBAO_ASSIGNEE_MAP.put("qbao-iOS", "dinghao.zhang");
        QBAO_ASSIGNEE_MAP.put("qbao-Android", "guanyuan.hou");

        SEVERITY_MAP = new HashMap<>();
        SEVERITY_MAP.put(0, 4);
        SEVERITY_MAP.put(1, 3);
        SEVERITY_MAP.put(2, 2);
        SEVERITY_MAP.put(3, 1);
    }

    public static String STATUS_ACTIVE = "active";
    public static String DESCRIPTION_URL = "<br/ ><a href=\"https://work.bugtags.com/apps/{appId}/issues/{issueId}/tags/{tagId}\" target=\"_blank\">https://work.bugtags.com/apps/{appId}/issues/{issueId}/tags/{tagId}</a><br />";
    public static Integer QBAO_PRODUCT_ID = 3;
}
