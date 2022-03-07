package com.cloud.chang.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileUtil {

	public static void write2File(String fileName, String content) {
		BufferedWriter bw = null;

		File file = new File(fileName);
		File baseDir = new File(file.getParent());
		if (!baseDir.exists()) {
			baseDir.mkdirs();
		}
		try {
			file.createNewFile();
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(content);
		} catch (Exception e) {
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
			}
		}
	}

	public static String file2String(String fileName) {
		File file = new File(fileName);
		StringBuilder str = new StringBuilder("");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line;
			while ((line = br.readLine()) != null) {
				str.append(line).append("\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
			}
		}
		return str.toString();
	}

	public static void append2File(String fileName, String content) {
		File file = new File(fileName);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			raf.seek(file.length());
			raf.writeBytes(content);
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readFile(File file, Charset encoding) {
		try {
			byte[] encoded = Files.readAllBytes(Paths.get(file.toURI()));
			return new String(encoded, encoding);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static void writeFile(File file, String content, Charset encoding) {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		byte[] encoded = content.getBytes(encoding);
		try {
			Files.write(Paths.get(file.toURI()), encoded, StandardOpenOption.WRITE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readFileStringWithClasspath(Object obj, String fileName) {
		try {
			Path path = Paths.get(obj.getClass().getClassLoader().getResource(fileName).toURI());
			byte[] fileBytes = Files.readAllBytes(path);
			return new String(fileBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String resolveCode(String path) {
		String code = "UTF-8";
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(path);
			byte[] head = new byte[3];
			inputStream.read(head);

			System.out.println(head[0] + "," + head[1] + "," + head[2]);

			code = "GBK";
			if (head[0] == -1 && head[1] == -2)
				code = "UTF-16";
			else if (head[0] == -2 && head[1] == -1)
				code = "Unicode";
			else if (head[0] == -17 && head[1] == -69 && head[2] == -65)
				code = "UTF-8";

		} catch (Exception e) {
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
				}
			}
		}
		return code;
	}

	public static String file2String2(String filePath) {
		String charsetName = resolveCode(filePath);
		System.out.println(charsetName);
		StringBuilder str = new StringBuilder("");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), charsetName));
			String line;
			while ((line = br.readLine()) != null) {
				str.append(line).append("\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
			}
		}
		return str.toString();
	}

}
