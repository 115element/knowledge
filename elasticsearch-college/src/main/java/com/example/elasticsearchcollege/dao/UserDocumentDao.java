package com.example.elasticsearchcollege.dao;

import com.example.elasticsearchcollege.document.UserDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDocumentDao extends ElasticsearchRepository<UserDocument,String> {
}
