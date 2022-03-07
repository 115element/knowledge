package com.cloud.chang.util.file;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

import java.util.Observable;
import java.util.Observer;

public class FileObserver implements Observer {

	private FileEventCallback fileEventCallback;
	private String subffix;

	public FileObserver(String subffix, FileEventCallback fileEventCallback) {
		this.subffix = subffix;
		this.fileEventCallback = fileEventCallback;
	}

	@Override
	public void update(Observable observable, Object eventArgs) {
		FileSystemEventArgs args = (FileSystemEventArgs) eventArgs;
		// 交换通道的临时文件结尾.unimastmp
		if (args.getFileName().endsWith(subffix) && args.getKind().equals(ENTRY_CREATE)) {
			if (fileEventCallback != null) {
				fileEventCallback.onFileCreated(args.getFileName());
			}
		}
	}
}