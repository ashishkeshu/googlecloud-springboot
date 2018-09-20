package com.firekernel.demo.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FireLog {
	public static void v(Logger logger, String msg) {
		logger.info(msg);
	}

	public static void i(Logger logger, String msg) {
		logger.info(msg);
	}

	public static void d(Logger logger, String msg) {
		logger.info(msg);
	}

	public static void w(Logger logger, String msg) {
		logger.info(msg);
	}

	public static void e(Logger logger, Throwable t) {
		logger.log(Level.SEVERE, t.getMessage());
	}

	public static void e(Logger logger, String msg, Throwable t) {
		logger.log(Level.SEVERE, msg, t.getMessage());
	}
}
