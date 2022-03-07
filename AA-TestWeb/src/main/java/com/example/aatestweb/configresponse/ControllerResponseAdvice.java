package com.example.aatestweb.configresponse;


import com.example.aatestweb.hook.R;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * 该类的作用是，让项目中的接口都有统一的返回值类型。
 */

@Slf4j
@RestControllerAdvice(basePackages = {"com.example.aatestweb.controllerspcial"}) //注意哦，这里要加上需要扫描的包
public class ControllerResponseAdvice implements ResponseBodyAdvice<Object> {

    //用来判断接口返回值是否需要包装，也就是执行下面beforeBodyWrite()
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
        //如果接口返回值的类型本事就是R类型，那就没有必要进行额外操作，返回FALSE
        return !returnType.getParameterType().equals(R.class);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter returnType, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        R response = R.ok().setData(o);

        //String类型不能直接包装，所以需要进行特别的处理
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                //将数据包装在response里后，再转换为JSON字符串响应给前端。
                return objectMapper.writeValueAsString(response);
            } catch (JsonProcessingException e) {
                throw new RuntimeException("String类型的返回值处理时发生错误");
            }
        }
        return response;
    }
}
