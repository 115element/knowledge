package com.cloud.chang.util.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.util.ReflectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReloadablePropertyPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    private static final Logger log = LoggerFactory.getLogger(ReloadablePropertyPostProcessor.class);
    private static final Map<String, BeanPropHolder> BEAN_PROP = new ConcurrentHashMap<>(256);
    private volatile PropertiesManager pm;
    private final ReadablePropertySourcesPlaceholderConfigurer readablePropertySourcesPlaceholderConfigurer;

    @Autowired
    public ReloadablePropertyPostProcessor(ReadablePropertySourcesPlaceholderConfigurer readablePropertySourcesPlaceholderConfigurer) {
        this.readablePropertySourcesPlaceholderConfigurer = readablePropertySourcesPlaceholderConfigurer;
    }

    @PostConstruct
    private void init() {
        if (null == readablePropertySourcesPlaceholderConfigurer) {
            throw new IllegalStateException("readablePropertySourcesPlaceholderConfigurer");
        }
        if (null != pm) {
            throw new IllegalStateException("PropertiesManager");
        }
        pm = PropertiesManager.create(readablePropertySourcesPlaceholderConfigurer);
    }

    @PreDestroy
    private void destory() {
        if (null != pm) {
            pm.destory();
        }
        if (null != BEAN_PROP) {
            BEAN_PROP.clear();
        }
    }

    @Override
    public boolean postProcessAfterInstantiation(final Object bean, final String beanName) throws BeansException {
        log.info("beanName=" + beanName);
        if (log.isDebugEnabled()) {
            log.debug("post beanName=" + beanName);
        }
        ReflectionUtils.doWithFields(bean.getClass(), ReflectionCallback.create(bean,
                readablePropertySourcesPlaceholderConfigurer));
        return true;
    }

    protected static void putProp4Init(final String k, final BeanPropHolder b) {
        if (null == k || null == b) {
            return;
        }
        BEAN_PROP.put(k, b);
    }

    public static Map<String, BeanPropHolder> getBeanProp() {
        return BEAN_PROP;
    }

}
