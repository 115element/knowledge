package com.example.demo.hook;

import com.example.demo.exception.Forward;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Slf4j
@UtilityClass
public class CtlUtils {
    public HttpServletRequest request() {
        return BeanHook.self().getRequest();
    }

    public HttpServletResponse response() {
        return BeanHook.self().getResponse();
    }

    public HttpSession session() {
        return request().getSession();
    }

    public String sessionId(){
        return session().getId();
    }

    public ServletContext application() {
        return request().getServletContext();
    }



    // nullable
    @SuppressWarnings("unchecked")
    public <T> T getAttribute(String key) {
        var res = request().getAttribute(key);
        if (res != null) return (T) res;
        res = session().getAttribute(key);
        if (res != null) return (T) res;
        return (T) application().getAttribute(key);
    }

    public void setAttribute(String key, Object value) {
        session().setAttribute(key, value);
    }

    public void removeAttribute(String key) {
        BeanHook.self()
                .getRequest()
                .getSession(true)
                .removeAttribute(key);
    }

    public String getAttributeString(String key) {
        Object obj = getAttribute(key);
        return obj == null ? "" : obj.toString();
    }

    public String getHeader(String key) {
        return BeanHook.self().getRequest().getHeader(key);
    }

    public String getLowerCaseUserAgent() {
        var userAgent = getHeader("User-Agent").toLowerCase();
        log.info("userAgent:{}", userAgent);
        return userAgent;
    }

    public String servletPath() {
        return BeanHook.self()
                .getRequest()
                .getServletPath();
    }

    public ServletContext servletContext() {
        return BeanHook.self().getRequest().getServletContext();
    }

    public void requireWechatBrowser() {
        var isWechatBrowser = getLowerCaseUserAgent()
                .contains("micromessenger");
        if (!isWechatBrowser)
            throw new Forward("error_msg").withAttr("errorMsg", "请在微信浏览器打开哦");
    }

    public boolean isWechatBrowser() {
        return getLowerCaseUserAgent().contains("micromessenger");
    }

    //非微信浏览器
    public boolean isNotWeChatBrowser() {
        return !(getLowerCaseUserAgent().contains("micromessenger"));
    }

    public void deleteHttpSessionIfExist() {
        HttpSession session = request().getSession(false);
        if (Objects.isNull(session)) return;
        session.invalidate();
    }

    public void clearIdSet(String name) {
        HttpSession session = request().getSession(false);
        if (Objects.nonNull(session)) session.removeAttribute(name);
    }

    public void setIdList(String name, List<Long> pkgIds) {
        var session = request().getSession(true);
        session.setAttribute(name, pkgIds);
    }

    @SuppressWarnings(value = "unchecked")
    public List<Long> getIdList(String name) {
        HttpSession session = request().getSession(true);
        Object obj = session.getAttribute(name);
        if (obj != null) {
            return (List<Long>) obj;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public Set<Long> getIdSet(String name) {
        HttpSession session = request().getSession(true);
        Object obj = session.getAttribute(name);
        if (obj != null) {
            return (Set<Long>) obj;
        }
        return null;
    }

    public void setIdSet(String name, Set<Long> pkgIds) {
        HttpSession session = request().getSession(true);
        Set<Long> exist = getIdSet(name);
        if (exist != null) {
            exist.addAll(pkgIds);
        } else {
            exist = pkgIds;
        }
        session.setAttribute(name, exist);
    }

    public String getAccessDeviceType() {
        var agent = getHeader("User-Agent");
        if (StringUtils.isBlank(agent)) return "";
        var agency = agent.toLowerCase();
        if (agency.contains("android")) return "android";
        if (agency.contains("ios")) return "ios";
        return "";
    }
}
