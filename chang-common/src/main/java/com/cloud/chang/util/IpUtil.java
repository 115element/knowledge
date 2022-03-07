package com.cloud.chang.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class IpUtil {

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

}
