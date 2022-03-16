package com.example.elasticsearchcollege.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Objects;


@Slf4j
@Configuration
public class ElasticSearchConfig {

    @PostConstruct
    void init() {
        System.out.println("该注解表示，构造方法执行之后执行该方法");
    }

    @Value("${elasticsearch.ip}")
    private String[] ipAddress;
    @Value("${elasticsearch.timeout}")
    private int Timeout;

    @Bean(name = "highLevelClient")
    public RestHighLevelClient setConnectTimeOutConfig() {
        RestClientBuilder restClientBuilder = restClientBuilder().setRequestConfigCallback(requestConfigBuilder -> {
            //①ConnectionRequestTimeout
            //httpclient使用连接池来管理连接，这个时间就是从连接池获取连接的超时时间，可以想象下数据库连接池
            //②ConnectTimeout
            //连接建立时间，三次握手完成时间
            //③SocketTimeout
            //数据传输过程中数据包之间间隔的最大时间
            requestConfigBuilder.setConnectTimeout(Timeout);
            requestConfigBuilder.setSocketTimeout(Timeout * 2);
            requestConfigBuilder.setConnectionRequestTimeout(Timeout);
            return requestConfigBuilder;
        });
        return new RestHighLevelClient(restClientBuilder);
    }


    public RestClientBuilder restClientBuilder() {
        HttpHost[] hosts = Arrays.stream(ipAddress)
                .map(this::makeHttpHost).filter(Objects::nonNull)
                .toArray(HttpHost[]::new);
        log.debug("hosts:{}", Arrays.toString(hosts));
        return RestClient.builder(hosts);
    }

    private HttpHost makeHttpHost(String s) {
        assert StringUtils.isNotEmpty(s);
        String[] address = s.split(":");
        if (address.length == 2) {
            String ip = address[0];
            int port = Integer.parseInt(address[1]);
            return new HttpHost(ip, port, "http");
        } else {
            return null;
        }
    }


    public static final RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(
                    new HttpHost("localhost", 9200, "http"),
                    new HttpHost("localhost", 9201, "http")));
}
