package test.cloud.chang;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.cloud.chang.util.secure.DesUtil;

public class DESTest {

	private static String srcDir = "C:\\work\\tools\\video.vue.android\\assets\\filter";
	private static String dstDir = "C:\\work\\png";

	public static void main(String[] args) throws Exception {
		String key = "yueRan8244k~*/!@";
		System.out.println(key.length());

		File dir = new File(srcDir);
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			String pathName = files[i].getAbsolutePath();
			Path path = Paths.get(pathName);
			byte[] data = Files.readAllBytes(path);
			byte[] decodeBs = DesUtil.decrypt(data, key, "AES");
			Files.write(Paths.get(dstDir + "/" + files[i].getName() + ".png"), decodeBs);
		}

		// Path path =
		// Paths.get("C:\\work\\tools\\video.vue.android\\assets\\filter\\B1");
		// byte[] data = Files.readAllBytes(path);
		// byte[] decodeBs = DesUtil.decrypt(data, key, "AES");
		// Files.write(Paths.get("C:\\\\work\\\\tools\\\\B1_decode"), decodeBs);
	}

}
