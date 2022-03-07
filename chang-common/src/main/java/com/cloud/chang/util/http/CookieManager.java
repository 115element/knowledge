package com.cloud.chang.util.http;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import org.apache.http.Header;

public class CookieManager {

	// private static Logger log = LoggerFactory.getLogger(CookieManager.class);

	private Map<String, Map<String, Cookie>> store;

	private static final String SET_COOKIE = "Set-Cookie";
	private static final String PATH = "Path";
	private static final String EXPIRES = "Expires";
	private static final String DOMAIN = "Domain";
	private static final String DATE_FORMAT_0 = "EEE, dd MMM yyyy hh:mm:ss 'GMT'";

	private static final String DATE_FORMAT_1 = "EEE, dd-MMM-yyyy hh:mm:ss 'GMT'";

	private DateFormat dateFormat0;
	private DateFormat dateFormat1;

	public CookieManager() {
		store = new HashMap<String, Map<String, Cookie>>();
		dateFormat0 = new SimpleDateFormat(DATE_FORMAT_0, Locale.US);
		dateFormat0.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));

		dateFormat1 = new SimpleDateFormat(DATE_FORMAT_1, Locale.US);
		dateFormat1.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
	}

	public void clear() {
		store.clear();
	}

	public String getStoredCookies(String _url) {
		URL url = null;
		try {
			url = new URL(_url);
		} catch (MalformedURLException e) {
		}
		if (url == null) {
			return "";
		}

		String domain = url.getHost();
		int strLength = domain.length();

		int dotNum = strLength - domain.replace(".", "").length();

		String cookieString = getCookie(domain);
		// log.debug("domain=" + domain + ", " + cookieString);
		if (dotNum >= 2) {
			int lastDotPosition = 0;
			for (int i = dotNum; i > 1; i--) {
				lastDotPosition = domain.indexOf(".", lastDotPosition + 1);
				String nextDomain = domain.substring(lastDotPosition);
				String domainCookie = getCookie(nextDomain);
				// log.debug("domain=" + nextDomain + ", " + domainCookie);
				cookieString += domainCookie;
			}
		}
		return cookieString;
	}

	public void storeCookies(URL url, Map<String, List<String>> headers) {
		if (url == null) {
			return;
		}
		String domain = url.getHost();
		Set<String> headerFieldKeys = headers.keySet();
		for (String key : headerFieldKeys) {
			if (SET_COOKIE.equalsIgnoreCase(key)) {
				List<String> valueList = headers.get(key);
				for (String cookieString : valueList) {
					Cookie cookie = buildCookie(cookieString);
					if (!isNotExpired(cookie.expires)) {
						continue;
					}
					if ("".equals(cookie.domain)) {
						cookie.domain = domain;
					}
					Map<String, Cookie> domainStore;
					if (store.containsKey(cookie.domain)) {
						domainStore = store.get(cookie.domain);
					} else {
						domainStore = new HashMap<String, Cookie>();
						store.put(cookie.domain, domainStore);
					}
					if (domainStore.containsKey(cookie.name)) {
						// log.warn("domain=" + domain + ", " + domainStore.get(cookie.name) +
						// " will repalce to "
						// + cookie);
					}
					// log.debug("domain=" + domain + ", name=" + cookie.name + cookie);
					domainStore.put(cookie.name, cookie);
				}
			}
		}
	}

	public void storeCookies(String _url, Header[] headers) {

		URL url = null;
		try {
			url = new URL(_url);
		} catch (MalformedURLException e) {
		}
		if (url == null) {
			return;
		}
		String domain = url.getHost();

		for (Header header : headers) {
			if (SET_COOKIE.equalsIgnoreCase(header.getName())) {
				Cookie cookie = buildCookie(header.getValue());
				if (!isNotExpired(cookie.expires)) {
					continue;
				}
				if ("".equals(cookie.domain)) {
					cookie.domain = domain;
				}
				Map<String, Cookie> domainStore;
				if (store.containsKey(cookie.domain)) {
					domainStore = store.get(cookie.domain);
				} else {
					domainStore = new HashMap<String, Cookie>();
					store.put(cookie.domain, domainStore);
				}
				if (domainStore.containsKey(cookie.name)) {
					// log.warn("domain=" + domain + ", " + domainStore.get(cookie.name) + " will
					// repalce to "
					// + cookie);
				}
				// log.debug("domain=" + cookie.domain + ", name=" + cookie.name + cookie);
				domainStore.put(cookie.name, cookie);
			}
		}
	}

	protected void putCookie(String domain, String name, String value) {
		if (SET_COOKIE.equalsIgnoreCase(name)) {
			Cookie cookie = buildCookie(value);
			if (!isNotExpired(cookie.expires)) {
				return;
			}
			if ("".equals(cookie.domain)) {
				cookie.domain = domain;
			}
			Map<String, Cookie> domainStore;
			if (store.containsKey(cookie.domain)) {
				domainStore = store.get(cookie.domain);
			} else {
				domainStore = new HashMap<String, Cookie>();
				store.put(cookie.domain, domainStore);
			}
			if (domainStore.containsKey(cookie.name)) {
				// log.warn("domain=" + domain + ", " + domainStore.get(cookie.name) + " will
				// repalce to "
				// + cookie);
			}
			// log.debug("domain=" + cookie.domain + ", name=" + cookie.name + cookie);
			domainStore.put(cookie.name, cookie);
		}
	}

	private String getCookie(String domain) {
		Map<String, Cookie> domainStore = store.get(domain);
		String cookieString = "";
		if (domainStore != null) {
			Set<String> cookieNames = domainStore.keySet();
			for (String cookieName : cookieNames) {
				Cookie cookie = domainStore.get(cookieName);
				if (cookie != null && isNotExpired(cookie.expires)) {
					cookieString += cookie.value + "; ";
				}
			}
		}
		return cookieString;
	}

	private boolean isNotExpired(String cookieExpires) {
		if (cookieExpires == null || "".equals(cookieExpires))
			return true;
		Date now = new Date();
		try {
			Date date;
			if (!cookieExpires.contains("-")) {
				date = dateFormat0.parse(cookieExpires);
			} else {
				date = dateFormat1.parse(cookieExpires);
			}
			return (now.compareTo(date)) <= 0;
		} catch (java.text.ParseException pe) {
			pe.printStackTrace();
			return false;
		}
	}

	public Cookie buildCookie(String cookieString) {
		String[] elements = cookieString.split("(; )");
		Cookie cookie = new Cookie();
		for (int i = 0; i < elements.length; i++) {
			if (i == 0) {
				cookie.name = elements[i].substring(0, elements[i].indexOf("="));
				cookie.value = elements[i];
			} else {
				if (elements[i].startsWith(EXPIRES)) {
					cookie.expires = elements[i].substring(elements[i].indexOf("=") + 1);
				} else if (elements[i].startsWith(PATH)) {
					cookie.path = elements[i].substring(elements[i].indexOf("=") + 1);
				} else if (elements[i].startsWith(DOMAIN)) {
					cookie.domain = elements[i].substring(elements[i].indexOf("=") + 1);
				}
			}
		}
		return cookie;
	}

	private class Cookie {
		public String name = "";
		public String value = "";
		public String expires = "";
		public String path = "";
		public String domain = "";

		@Override
		public String toString() {
			return "Cookie [name=" + name + ", value=" + value + ", expires=" + expires + ", path=" + path + ", domain="
					+ domain + "]";
		}
	}
}
