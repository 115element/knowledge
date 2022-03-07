package com.example.logmonitor.enumeration;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ActionCall {

    public final Map<String, List<String>> actionMap = new HashMap<String, List<String>>() {
        {
            put("get", getList);
            put("post", postList);
            put("del", delList);
            put("put", putList);
        }
    };

    public static final Map<String, String> actionStrMap = new HashMap<String, String>() {
        {
            put("accountQuery", "查询账户");
            put("domainQueryList", "查询域名列表");
            put("online", "启用域名");
            put("offline", "禁用域名");
            put("delete", "删除域名");
            put("domainAdd", "新增域名");
            put("domainModify", "修改域名");
            put("cdnFlow", "查询流量");
            put("cdnBandwidth", "查询带宽");
            put("purge", "刷新");
            put("purgeCheck", "刷新查询");
            put("prefetch", "预热");
            put("prefetchCheck", "预热查询");
            put("certificateQueryList", "查询证书列表");
            put("certificateQuery", "查询证书详情");
            put("certificateUpload", "上传证书");
            put("certificateBind", "证书绑定域名");
            put("certificateDelete", "证书删除");
            put("cdnIpCount", "独立IP");
            put("cdnHitRate", "命中率");
            put("cdnStatusCode", "响应状态码");
            put("cdnTopUrl", "topurl");
            put("cdnReferer", "来源");
            put("cdnRequest", "总请求数");
            put("cdnLogUrl", "日志下载");
            put("certificateBindShareAccount", "修改证书共享账户");
        }
    };

    public static final Map<String, String> bodyMap = new HashMap<String, String>() {
        {
            put("online", "50001");
            put("offline", "50001");
            put("domainAdd", "50001");
            put("domainModify", "50001");
            put("cdnFlow", "60001");
            put("cdnBandwidth", "60001");
            put("purge", "70001");
            put("prefetch", "70001");
            put("certificateUpload", "80001");
            put("certificateBind", "80001");
            put("certificateBindShareAccount", "80001");
            put("cdnIpCount", "90001");
            put("cdnStatusCode", "90001");
            put("cdnTopUrl", "90001");
            put("cdnReferer", "90001");
            put("cdnHitRate", "90001");
            put("cdnRequest", "90001");
            put("cdnLogUrl", "90001");
        }
    };

    private final static List<String> getList = new ArrayList<String>() {
        {
            add("accountQuery");
            add("domainQueryList");
            add("purgeCheck");
            add("prefetchCheck");
            add("certificateQueryList");
            add("certificateQuery");
        }
    };

    private final static List<String> postList = new ArrayList<String>() {
        {
            add("domainAdd");
            add("cdnFlow");
            add("cdnBandwidth");
            add("purge");
            add("prefetch");
            add("certificateUpload");
            add("cdnIpCount");
            add("cdnStatusCode");
            add("cdnTopUrl");
            add("cdnReferer");
            add("cdnHitRate");
            add("cdnRequest");
            add("cdnLogUrl");
        }
    };

    private final static List<String> delList = new ArrayList<String>() {
        {
            add("delete");
            add("certificateDelete");
        }
    };

    private final static List<String> putList = new ArrayList<String>() {
        {
            add("online");
            add("certificateBind");
            add("offline");
            add("domainModify");
            add("certificateBindShareAccount");
        }
    };
}
