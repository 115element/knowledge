package com.example.onerequestcount.jpainterceptor;

import com.example.onerequestcount.counter.Counter;
import com.example.onerequestcount.counter.CounterImprove;
import org.hibernate.resource.jdbc.spi.StatementInspector;

public class JpaInterceptor implements StatementInspector {


    @Override
    public String inspect(String sql) {
        //Counter.addOne();
        CounterImprove.addOne();
        System.out.println("(哈哈)进入拦截器:" + sql);

        return sql;
    }
}
