package com.cloud.chang.util.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;

/**
 * 用法：controller 单例，线程非安全 , 增加了web scope resolver 后实现了线程安全 
 * <context:component-scan base-package="net.unitedcloud.*.controller"
 * scope-resolver="net.unitedcloud.chang.util.WebScopeResolver" />
 * 
 * @author bingyunxl
 * 
 */
public class WebScopeResolver implements ScopeMetadataResolver {

	public ScopeMetadata resolveScopeMetadata(BeanDefinition beanDefinition) {
		ScopeMetadata metadata = new ScopeMetadata();
		metadata.setScopeName("prototype");
		return metadata;
	}
}
