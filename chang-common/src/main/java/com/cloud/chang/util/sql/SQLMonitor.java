package com.cloud.chang.util.sql;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class SQLMonitor {

	private Timer timer;

	private long lastModifyTime = 0;

	private final String path = this.getClass().getClassLoader()
			.getResource("sql.xml").getPath();

	public SQLMonitor() {
		lastModifyTime = new File(path).lastModified();
		timer = new Timer(true);
		timer.schedule(new SQLNotifier(), 0, 10000);
	}

	class SQLNotifier extends TimerTask {
		@Override
		public void run() {
			long time = new File(path).lastModified();
			if (time > lastModifyTime) {
				SQLFactory.setParser(new SQLParser());
			}
		}

	}
}
