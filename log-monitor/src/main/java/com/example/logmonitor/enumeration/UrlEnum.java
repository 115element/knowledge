package com.example.logmonitor.enumeration;

public enum UrlEnum {
    URLPURGETOTAL("refreshUrlDailyMax"),
    URLPURGEONCE("refreshUrlSingleMax"),
    URLPREFETCHTOTAL("cacheUrlDailyMax"),
    URLPREFETCHONCE("cacheUrlSingleMax");
    private String str;

    UrlEnum() {
    }

    UrlEnum(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
