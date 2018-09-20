package com.firekernel.demo.util;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class Utils {

	public static String issueToken() {
		Random random = new SecureRandom();
		String token = new BigInteger(130, random).toString(32);
		return token;
	}

	public static boolean isEmpty(String str) {
		return (str == null || str.trim().length() == 0);
	}

	public static void setIfNotEmpty() {
	}
}
