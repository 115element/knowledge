package com.example.elasticsearchcollege.single;


import org.elasticsearch.action.search.SearchRequest;

/**
 * 只是演示枚举的特殊用法；
 * 枚举单例模式，第一次见这种用法。
 */
public enum Singleton {
    INSTANCE;

    private SearchRequest searchRequest = new SearchRequest();

    public SearchRequest getSearchRequest() {
        return searchRequest;
    }

    public void setSearchRequest(SearchRequest name) {
        this.searchRequest = name;
    }
}

