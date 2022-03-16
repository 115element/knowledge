package com.example.elasticsearchcollege.service;

import com.alibaba.fastjson.JSON;
import com.example.elasticsearchcollege.document.UserLog;
import lombok.val;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EsService {

    @Autowired
    private RestHighLevelClient client;

    public void insert() throws IOException {
        UserLog log = new UserLog();
        log.setId(101L);
        log.setTitle("足球");
        log.setDesc("足球是世界第一运行");
        log.setCategory("体育");

        IndexRequest indexRequest = new IndexRequest("userlog_index");
        indexRequest.source(JSON.toJSONString(log), XContentType.JSON);
        val response = client.index(indexRequest, RequestOptions.DEFAULT);

        System.out.println(response.status());
        System.out.println(response);
    }

    public void searchIndex() throws IOException {
        SearchRequest searchRequest = new SearchRequest("userlog_index");
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        QueryBuilder qb = new MatchQueryBuilder("desc","世界");
        ssb.query(qb);
        searchRequest.source(ssb);
        final SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit hit : hits) {
            String record = hit.getSourceAsString();
            System.out.println(record);
        }
    }

    public void searchAggregation() throws IOException {
        SearchRequest searchRequest = new SearchRequest("userlog_index");
        SearchSourceBuilder ssb = new SearchSourceBuilder();

        /**
         * 同样，我们创建一个SearchRequest，然后再创建一个TermsAggregationBuilder，
         * TermsAggregationBuilder我们指定了name叫做category，这个name对应着上一节中的那个自定义的名称，大家还有印象吗？
         * 后面的field是我们要聚合的字段，注意这里因为category字段是text类型，
         * 默认是不能够做聚合查询的，我们指定的是category.keyword，还记得这个keyword类型吗？它是不使用分词器的，我们使用这个keyword类型是可以的。
         * 最后把AggregationBuilder封装到查询请求中，进行查询。
         */
        TermsAggregationBuilder category = AggregationBuilders.terms("category").field("category.keyword");
        ssb.aggregation(category);

        searchRequest.source(ssb);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        Terms terms = response.getAggregations().get("category");
        for (Terms.Bucket bucket : terms.getBuckets()) {
            System.out.println(bucket.getKey());
            System.out.println(bucket.getDocCount());
        }
    }
}
