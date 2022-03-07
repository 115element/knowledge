package com.cloud.chang.util.spring;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NotNullAttributeMapper extends ObjectMapper {

	private static final long serialVersionUID = -3372332218492806504L;

	public NotNullAttributeMapper() {
		super();
		this.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		this.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
		this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	}
}
