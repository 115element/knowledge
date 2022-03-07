package test.cloud.chang;

import java.util.Map;

import com.cloud.chang.util.FileUtil;
import com.cloud.chang.util.Util;

public class Test3 {

	public static void main(String[] args) {
		String filename = "C:/worktmp/1.json";
		String str = FileUtil.file2String(filename);
		Map<String, String> map = Util.json2Object(str, Map.class);
		System.out.println(map);

	}

}
