package com.jd.szm;

import java.text.SimpleDateFormat;

public class SyncLogger {
	private static SyncLogger logger = new SyncLogger();
	public static final int ErrorLevel = 0;
	public static final int WarnLevel = 1;
	public static final int InfoLevel = 2;
	public static final int DebugLevel = 3;
	private int logLevel = InfoLevel;
	public int getLogLevel() {
		return logLevel;
	}
	public void setLogLevel(int logLevel) {
		this.logLevel = logLevel;
	}

	private SyncLogger() {}
	public static SyncLogger getLogger() {
		return logger;
	}
	public void err(String msg) {
		if (logLevel >= ErrorLevel)
			syncPrint("[ERROR] " + "[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) +"] "+ msg);
	}
	public void warn(String msg) {
		if (logLevel >= WarnLevel)
			syncPrint("[WARNING] " + "[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) +"] "+ msg);
	}
	public void info(String msg) {
		if (logLevel >= InfoLevel)
			syncPrint("[INFO] " + "[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) +"] "+ msg);
	}
	public void debug(String msg) {
		if (logLevel >= DebugLevel)
			syncPrint("[DEBUG] " + "[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) +"] "+ msg);
	}
	private synchronized void syncPrint(String msg) {
		System.out.println(msg);
	}
}
