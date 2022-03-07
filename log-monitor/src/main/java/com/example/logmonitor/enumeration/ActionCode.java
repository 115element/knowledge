package com.example.logmonitor.enumeration;


public enum ActionCode {
    //查询域名列表
    DOMAINQUERYLIST("domainQueryList"),
    //启用域名
    ONLINE("online"),
    //禁用域名
    OFFLINE("offline"),
    //删除域名
    DELETE("delete"),
    //新增域名
    DOMAINADD("domainAdd"),
    //修改域名
    DOMAINMODIFY("domainModify"),
    //查询证书列表
    CERTIFICATEQUERYLIST("certificateQueryList"),
    //查询证书详情
    CERTIFICATEQUERY("certificateQuery"),
    //上传证书
    CERTIFICATEUPLOAD("certificateUpload"),
    //证书绑定域名
    CERTIFICATEBIND("certificateBind"),
    //证书删除
    CERTIFICATEDELETE("certificateDelete");
    private String action;

    ActionCode(String action) {
        this.action = action;
    }

    ActionCode() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
