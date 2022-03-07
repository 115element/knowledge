package com.example.onerequestcount.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor implements HandlerInterceptor {


    //这个方法是在访问接口之前执行的,我们只需要在这里写验证登陆状态的业务逻辑,就可以在用户调用指定接口之前验证登陆状态了
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //每一个项目对于登陆的实现逻辑都有所区别,我这里使用最简单的Session提取User来验证登陆。
        System.out.println("②拦截器 preHandle");
        return true;
    }

    //请求处理之后进行调用,但是在视图被渲染之前(Controller方法调用之后)
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("③拦截器 postHandle");
    }

    //在整个请求结束之后被调用
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("④拦截器 afterCompletion");
    }

}
