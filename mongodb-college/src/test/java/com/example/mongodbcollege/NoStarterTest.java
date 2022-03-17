package com.example.mongodbcollege;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClientFactory;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.internal.MongoClientImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class NoStarterTest {


    //**MongoDb官网客户端连接示例
    @Test
    public void testMongoDb() {
        try {
            ConnectionString connString = new ConnectionString(
                    "mongodb+srv://<username>:<password>@<cluster-address>/test?w=majority"
            );
            final MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connString)
                    .retryWrites(true)
                    .build();
            final MongoClient mongoClient = MongoClients.create(settings);
            final MongoDatabase app = mongoClient.getDatabase("app");
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ":" + e.getMessage());
        }
    }

}
