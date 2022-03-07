package com.example.onerequestcount.filter;

import com.example.onerequestcount.counter.Counter;
import com.example.onerequestcount.counter.CounterImprove;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //Counter.restore();
        CounterImprove.restoreCounter();
        System.out.println("过滤器Begin");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("过滤器End");
        CounterImprove.getCounter();
        //Counter.getCounter();
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
