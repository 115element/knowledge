package com.cloud.chang.util.file;

import java.nio.file.WatchEvent.Kind;

public class FileSystemEventArgs {

	private final String fileName;
	private final Kind<?> kind;

	public FileSystemEventArgs(String fileName, Kind<?> kind) {
		this.fileName = fileName;
		this.kind = kind;
	}

	/**
	 * 文件的路径
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * 操作类型：变更、创建、删除
	 */
	@SuppressWarnings("rawtypes")
	public Kind getKind() {
		return kind;
	}
}
