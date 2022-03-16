package com.example.elasticsearchcollege;

import com.alibaba.fastjson.JSON;
import com.example.elasticsearchcollege.document.UserLog;
import com.example.elasticsearchcollege.single.Singleton;
import lombok.SneakyThrows;
import lombok.val;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.SecureRandom;

@SpringBootTest
class ElasticsearchCollegeApplicationTests {

    @Test
    void contextLoads() {
        Singleton instance = Singleton.INSTANCE;
        SearchRequest searchRequest = instance.getSearchRequest();
    }

    @Resource
    private RestHighLevelClient client;

    @SneakyThrows
    @Test
    public void createIndex() {
        SecureRandom secureRandom = new SecureRandom();
        val i = secureRandom.nextInt(1000);

        UserLog log = new UserLog();
        log.setId((long) i);
        log.setTitle("足球" + i);
        log.setDesc("足球是世界第一运行" + i);
        log.setCategory("体育" + i);


        IndexRequest indexRequest = new IndexRequest("userlog_index");
        indexRequest.source(JSON.toJSONString(log), XContentType.JSON);
        val response = client.index(indexRequest, RequestOptions.DEFAULT);

        System.out.println(response.status());
        System.out.println(response);
    }



    @Test
    public void deleteApi() throws IOException {
        DeleteRequest request = new DeleteRequest(
                "userlog_index",//索引名称
                // "doc",//ES7已经取消了类型
                "-UQsjX8BDMqrZ5b6yRhP");//文档ID，

        //设置超时：等待主分片变得可用的时间
        request.timeout(TimeValue.timeValueMinutes(2));

        //同步执行
        DeleteResponse deleteResponse = client.delete(request, RequestOptions.DEFAULT);

        //Delete Response
        //返回的DeleteResponse允许检索有关执行操作的信息，如下所示：
        String index = deleteResponse.getIndex();
        String type = deleteResponse.getType();
        String id = deleteResponse.getId();
        long version = deleteResponse.getVersion();
        ReplicationResponse.ShardInfo shardInfo = deleteResponse.getShardInfo();
        if (shardInfo.getTotal() != shardInfo.getSuccessful()) {
            //处理成功分片数量少于总分片数量的情况
        }
        if (shardInfo.getFailed() > 0) {
            for (ReplicationResponse.ShardInfo.Failure failure : shardInfo.getFailures()) {
                String reason = failure.reason();//处理潜在的失败
            }
        }
    }
}
