package test.cloud.chang;

import com.cloud.chang.util.concurrent.TTLConcurrentHashMap;

public class Test2 {

	public static void main(String[] args) throws Exception {

		TTLConcurrentHashMap<String, String> map = new TTLConcurrentHashMap<>(10 * 1000);
		map.init();
		map.put("1", "test1");
		Thread.sleep(4 * 1000);
		map.put("2", "test2");
		Thread.sleep(4 * 1000);
		map.put("3", "test3");
		Thread.sleep(4 * 1000);
		map.put("4", "test4");
		Thread.sleep(4 * 1000);
		map.destory();
	}

}
