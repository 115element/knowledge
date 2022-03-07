package com.cloud.chang.util;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Util {

	private static ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

		mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

		JsonFactory factory = mapper.getFactory();
		factory.enable(JsonGenerator.Feature.ESCAPE_NON_ASCII);
		factory.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
	}

	public static String getCallTrace(String basePackge, Throwable throwable) {
		List<StackTraceElement> stackList = new ArrayList<StackTraceElement>();
		StackTraceElement[] stElement = throwable.getStackTrace();
		for (StackTraceElement element : stElement) {
			if (element.getClassName().trim().startsWith(basePackge)) {
				stackList.add(element);
			}
		}
		String callTraceString = "";
		int listSize = stackList.size();
		for (int i = 0; i < listSize; i++) {
			StackTraceElement element = stackList.get(i);
			callTraceString += element.getClassName() + "." + element.getMethodName() + "(" + element.getLineNumber()
					+ ")";
			if ((i + 1) != listSize) {
				callTraceString += " <-- ";
			}
		}
		return callTraceString;
	}

	public static String map2UrlString(Map<String, ? extends Object> paramsMap) {
		String paramString = "";
		Set<String> keys = paramsMap.keySet();
		for (String key : keys) {
			Object value = paramsMap.get(key);
			if (value != null) {
				try {
					paramString += key + "=" + URLEncoder.encode(value.toString(), "UTF-8") + "&";
					// paramString += key + "=" + value.toString() + "&";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return paramString;
	}

	public static Map<String, String> query2ParamsMap(String queryString) {
		Map<String, String> paramsMap = new HashMap<String, String>();
		if (queryString == null || "".equals(queryString)) {
			return null;
		}

		String[] params = queryString.split("&");

		for (String param : params) {
			String key = param.substring(0, param.indexOf("="));
			String value = param.substring(param.indexOf("=") + 1, param.length());
			try {
				paramsMap.put(key, URLDecoder.decode(value, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return paramsMap;
	}

	public static String getRndPlainText(int textLenth) {
		StringBuffer buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int range = buffer.length();
		for (int i = 0; i < textLenth; i++) {
			// 生成指定范围类的随机数0—字符串长度(包括0、不包括字符串长度)
			sb.append(buffer.charAt(r.nextInt(range)));
		}
		return sb.toString();
	}

	public static String getRemoteAddr(HttpServletRequest request) {

		Enumeration<String> names = request.getHeaderNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			System.out.println(name + ": " + request.getHeader(name));
		}

		String remoteIp = request.getHeader("x-forwarded-for");
		if (remoteIp == null || "".equals(remoteIp)) {
			remoteIp = request.getHeader("X-Real-IP");
		}
		if (remoteIp == null || "".equals(remoteIp)) {
			remoteIp = request.getRemoteAddr();
		}
		if (remoteIp != null && !"".equals(remoteIp) && remoteIp.contains(",")) {
			remoteIp = remoteIp.split(",")[0];
		}
		return remoteIp;
	}

	public static Map<String, String> obj2Map(Object obj) {
		Map<String, String> map = new HashMap<String, String>();
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String fieldName = field.getName();
			String fieldValue = "";
			try {
				if (field.get(obj) != null) {
					fieldValue = field.get(obj).toString();
				}
			} catch (Exception e) {
			}
			if (!StringUtils.isBlank(fieldValue)) {
				map.put(fieldName, fieldValue);
			}
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> toMap(Object obj) {
		Map<String, Object> props = null;
		try {
			props = mapper.convertValue(obj, Map.class);
		} catch (IllegalArgumentException e) {
		}
		return props;
	}

	@SuppressWarnings("rawtypes")
	public static Map<String, String> request2Map(HttpServletRequest request) {
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			try {
				valueStr = new String(valueStr.getBytes(), "utf-8");
			} catch (UnsupportedEncodingException e) {
			}
			params.put(name, valueStr);
		}
		return params;
	}

	/**
	 * 只支持基本数据类型
	 * 
	 * @param paramsMap
	 * @param clazz
	 * @return
	 */

	public static <T> T map2Obj(Map<String, String> paramsMap, Class<T> clazz, String... datePattern) {
		try {
			T instanceT = clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				String fieldName = field.getName();
				String value = paramsMap.get(fieldName);
				if (StringUtils.isBlank(value)) {
					continue;
				}
				Class<?> type = field.getType();
				if (type.equals(String.class)) {
					field.set(instanceT, value);
				} else if (type.equals(Integer.class) || type.equals(int.class)) {
					field.set(instanceT, Integer.valueOf(value));
				} else if (type.equals(Boolean.class) || type.equals(boolean.class)) {
					field.set(instanceT, Boolean.valueOf(value));
				} else if (type.equals(Long.class) || type.equals(long.class)) {
					field.set(instanceT, Long.valueOf(value));
				} else if (type.equals(Double.class) || type.equals(double.class)) {
					field.set(instanceT, Double.valueOf(value));
				} else if (type.equals(Date.class)) {
					try {
						SimpleDateFormat sdf = null;
						if (datePattern.length > 0) {
							sdf = new SimpleDateFormat(datePattern[0]);
						} else {
							sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						}
						Date date = sdf.parse(value);
						field.set(instanceT, date);
					} catch (Exception e) {
					}
				}
			}
			return instanceT;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T json2Object(String jsonString, Class<T> clazz, DateFormat... dateFormat) {
		if (dateFormat.length > 0) {
			mapper.setDateFormat(dateFormat[0]);
		}
		try {
			return mapper.readValue(jsonString, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T json2Object(String jsonString, TypeReference<T> typeReference, DateFormat... dateFormat) {
		if (dateFormat.length > 0) {
			mapper.setDateFormat(dateFormat[0]);
		}
		try {
			return mapper.readValue(jsonString, typeReference);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String object2Json(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String object2Xml(Object obj) {
		DomDriver drv = new DomDriver("UTF-8");
		XStream xstream = new XStream(drv);
		xstream.autodetectAnnotations(true);
		StringWriter writer = new StringWriter();
		writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		xstream.toXML(obj, writer);
		return writer.toString();
	}

	@SuppressWarnings("unchecked")
	public static <T> T xml2Object(String xml, Class<T> clazz) {
		DomDriver drv = new DomDriver("UTF-8");
		XStream xstream = new XStream(drv);
		xstream.autodetectAnnotations(true);
		xstream.ignoreUnknownElements();
		xstream.processAnnotations(clazz);
		return (T) xstream.fromXML(xml);
	}

	@SuppressWarnings("unchecked")
	public static <T> T convertType(String value, Class<T> clazz) {
		if (clazz == int.class || clazz == Integer.class) {
			return (T) (Object) Integer.parseInt(value);
		} else if (clazz == long.class || clazz == Long.class) {
			return (T) (Object) Long.parseLong(value);
		} else if (clazz == double.class || clazz == Double.class) {
			return (T) (Object) Double.parseDouble(value);
		} else if (clazz == float.class || clazz == Float.class) {
			return (T) (Object) Float.parseFloat(value);
		} else if (clazz == boolean.class || clazz == Boolean.class) {
			return (T) (Object) Boolean.parseBoolean(value);
		} else if (clazz == byte.class || clazz == Byte.class) {
			return (T) (Object) Byte.parseByte(value);
		} else if (clazz == String.class) {
			return (T) value;
		}
		return null;
	}

	public static boolean internalIp(String ip) {
		byte[] addr = getIpAddress(ip);
		final byte b0 = addr[0];
		final byte b1 = addr[1];
		// 10.x.x.x/8
		final byte SECTION_1 = 0x0A;
		// 172.16.x.x/12
		final byte SECTION_2 = (byte) 0xAC;
		final byte SECTION_3 = (byte) 0x10;
		final byte SECTION_4 = (byte) 0x1F;
		// 192.168.x.x/16
		final byte SECTION_5 = (byte) 0xC0;
		final byte SECTION_6 = (byte) 0xA8;
		switch (b0) {
		case SECTION_1:
			return true;
		case SECTION_2:
			if (b1 >= SECTION_3 && b1 <= SECTION_4) {
				return true;
			}
		case SECTION_5:
			switch (b1) {
			case SECTION_6:
				return true;
			}
		default:
			return false;
		}
	}

	public static byte[] getIpAddress(String ip) {
		String[] ipArray = ip.split("[.]");
		int[] ipIntArray = new int[4];
		for (int i = 0; i < ipArray.length; i++) {
			ipIntArray[i] = Integer.parseInt(ipArray[i].trim());
		}
		return new byte[] { (byte) ipIntArray[0], (byte) ipIntArray[1], (byte) ipIntArray[2], (byte) ipIntArray[3] };
	}

	public static String ipInt2String(int ipInt) {
		return new StringBuilder().append(((ipInt >> 24) & 0xff)).append('.').append((ipInt >> 16) & 0xff).append('.')
				.append((ipInt >> 8) & 0xff).append('.').append((ipInt & 0xff)).toString();
	}

	public static boolean isFakeMAC(String mac) {
		String macHead = mac.substring(0, 2);
		int intValue = Integer.parseInt(macHead, 16);
		System.out.println(intValue);
		String subStr = "";
		if (intValue == 0) {
			subStr = "00";
		} else if (intValue == 1) {
			subStr = "01";
		} else {
			String binStr = Integer.toBinaryString(intValue);
			System.out.println(binStr);
			subStr = binStr.substring(binStr.length() - 2, binStr.length());
		}
		return !"00".equals(subStr);
	}

	public static String getIpAddr(HttpServletRequest request) {

		String ip = null;
		ip = request.getHeader("x-forwarded-for");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个IP值，第一个为真实IP。
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		} else {
			ip = request.getHeader("x-real-ip");
			if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
				return ip;
			}
			return request.getRemoteAddr();
		}
	}

}
