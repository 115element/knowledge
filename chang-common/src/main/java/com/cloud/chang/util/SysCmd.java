package com.cloud.chang.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SysCmd {

	public static List<String> exec4Linux(String cmd) {
		Runtime runtime = Runtime.getRuntime();
		Process process = null;
		List<String> output = new ArrayList<String>();
		try {
			process = runtime.exec(new String[] { "sh", "-c", cmd });
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()), 8 * 1024);

			String line = br.readLine();
			while (line != null) {
				output.add(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}

}
