package com.cloud.chang.util.properties.oldproperties;

import java.lang.reflect.Field;
import java.util.Map;

import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.stereotype.Component;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Maps;

/**
 * Default implementation of {@link PropertyConversionService}, attempting to
 * convert an object otherwise utilising {@link SimpleTypeConverter} if no
 * matching converter is found.
 * 
 * @author James Morgan
 */
@Component
public class DefaultPropertyConversionService implements PropertyConversionService {

	private static final Map<Class<? extends Object>, Function<Object, ?>> CONVERTS = Maps.newHashMap();

	private static final SimpleTypeConverter DEFAULT = new SimpleTypeConverter();

	@Override
	public Object convertPropertyForField(final Field field, final Object property) {
		try {
			return Functions.forMap(CONVERTS, new DefaultConverter(field.getType())).apply(field.getType())
					.apply(property);
		} catch (final Throwable e) {
			throw new BeanInitializationException(String.format(
					"Unable to convert property for field [%s].  Value [%s] cannot be converted to [%s]",
					field.getName(), property, field.getType()), e);
		}
	}

	private static class DefaultConverter implements Function<Object, Object> {
		private final Class<?> type;

		public DefaultConverter(final Class<?> type) {
			this.type = type;
		}

		@Override
		public Object apply(final Object input) {
			return DEFAULT.convertIfNecessary(input, this.type);
		}
	}

}
