package com.cloud.chang.util.properties;

import com.cloud.chang.util.secure.DesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

public class ReadablePropertySourcesPlaceholderConfigurer extends PropertySourcesPlaceholderConfigurer {
	private static final Logger log = LoggerFactory.getLogger(ReadablePropertySourcesPlaceholderConfigurer.class);
	private volatile Properties properties;
	private volatile Resource[] locations;
	private static final String desKey = "YunDesPasswd";

	public ReadablePropertySourcesPlaceholderConfigurer() {

	}

	@Override
	protected void loadProperties(final Properties props) {
		superLoad(props);
		this.properties = props;
		afterPropsLoaded(props);
	}

	private void superLoad(final Properties props) {
		if (null == props) {
			throw new IllegalStateException("props");
		}
		try {
			super.loadProperties(props);
		} catch (IOException e) {
			log.error(e.toString(), e);
		} catch (Throwable t) {
			log.error(t.toString(), t);
		}
	}

	@Override
	public void setLocations(final Resource[] locations) {
		if (null == locations) {
			throw new IllegalStateException("locations");
		}
		superLocation(locations);
		this.locations = locations;
	}

	private void superLocation(final Resource[] locations) {
		super.setLocations(locations);
	}

	public Properties getProperties() {
		return this.properties;
	}

	public Resource[] getLocations() {
		return locations;
	}

	private void afterPropsLoaded(Properties props) {
		if (props == null) {
			return;
		}
		props.forEach((k, v) -> {
			if (needDecode(v)) {
				log.warn("props key=" + k + " was encoded,ready to decode");
				String strVal = (String) v;
				String origPasswd = strVal.substring(1, strVal.length() - 1);
				String decodePasswd = DesUtil.deCode(origPasswd, desKey, DesUtil.AES);
				if (decodePasswd == null) {
					throw new NullPointerException("Encoded <K,V> error.k=" + k + ",v=" + v);
				}
				props.replace(k, decodePasswd);
			}
		});
	}

	private boolean needDecode(Object v) {
		if (!(v instanceof String)) {
			return false;
		}
		String strVal = (String) v;
		if (strVal.startsWith("[") && strVal.endsWith("]")) {
			return true;
		}
		return false;
	}

}
