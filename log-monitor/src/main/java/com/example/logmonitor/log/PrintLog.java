package com.example.logmonitor.log;


import com.example.logmonitor.entity.Result;
import com.example.logmonitor.enumeration.ActionCall;
import com.example.logmonitor.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Slf4j
public class PrintLog {

    /**
     * 将日志输出到置顶日志
     *
     * @param request
     * @param response
     * @param body
     * @param respStr
     * @param now
     */
    public static void print(HttpServletRequest request, HttpServletResponse response, Object body, Result respStr, LocalDateTime now, String msg) {
        //String account = UriEncoder.decode(request.getParameter("account"));
        String accessKey = request.getHeader("accesskeyid");
        String uuid = request.getHeader("Request-id");
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        String queryString = request.getQueryString();
        String localAddr = "-";
        int status = response.getStatus();
        String action = request.getParameter("action");
        String actionStr = ActionCall.actionStrMap.get(action);
        Map<String, Object> message = JsonUtils.toMap(respStr);
        print(message, status, uuid, now, localAddr, method, queryString, body, requestURI, actionStr, msg, accessKey);
    }

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss:SSS");

    private static void print(Map<String, Object> message, int httpStatus, String uuid, LocalDateTime now, String address, String method, String queryString, Object body, String path, String target, String msg, String accessKey) {
//        log.info("{}  {}  {}  {}  {}  {}  {}  {}  {}  {}  {}  {}  {}", now.format(formatter), LocalDateTime.now().format(formatter), uuid, address, path, method, queryString, body != null ? JsonUtils.toJSONString(body) : "-", JsonUtils.toJSONString(message), httpStatus, "\"" + (StringUtils.isNotBlank(msg) ? msg : message.get("msg")) + "\"", "api-service", target);
        log.info("{}  {}  {}  {}  {}  {}  {}  {} {}  {}  {}  {}", now.format(formatter), LocalDateTime.now().format(formatter), uuid, accessKey, address, path, method, StringUtils.isNotBlank(queryString) ? queryString : "-", httpStatus, "\"" + (StringUtils.isNotBlank(msg) ? msg : message.get("msg")) + "\"", "domain_config", target);
    }
}
