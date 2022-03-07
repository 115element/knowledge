package com.example.jpacollege.jpa_querydls_and_dynamicsql;

import com.example.jpacollege.jpa_querydls_and_dynamicsql.entity.RefreshUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface RefreshUrlDao extends JpaRepository<RefreshUrl, Integer> {

    //查询未完成的url taskId
    @Query("select r from RefreshUrl r where r.actionId=:actionId and (r.status=-1 or r.status=2)")
    public List<RefreshUrl> getUrlTaskByStatus(@Param("actionId") int actionId);

    @Query(nativeQuery = true, value = "select * from t_refresh_url where action_id=?1 and provider=?2 and url in (?3)")
    public List<RefreshUrl> find(long actionId, String provider, Set<String> urls);
}
