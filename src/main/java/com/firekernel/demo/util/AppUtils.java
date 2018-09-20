package com.firekernel.demo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class AppUtils {

	private static final String UNICODE_FORMAT = "UTF8";
	public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	private KeySpec ks;
	private SecretKeyFactory skf;
	private Cipher cipher;
	byte[] arrayBytes;
	private String myEncryptionKey;
	private String myEncryptionScheme;
	private SecretKey key;

	public static AppUtils getInstance() {
		return LazyHolder.INSTANCE;
	}

	private AppUtils() {
		try {
			myEncryptionKey = "ThisisRKartavhisTsSparta";
			myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
			arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
			ks = new DESedeKeySpec(arrayBytes);
			skf = SecretKeyFactory.getInstance(myEncryptionScheme);
			cipher = Cipher.getInstance(myEncryptionScheme);
			key = skf.generateSecret(ks);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String encrypt(String unencryptedString) {
		if (unencryptedString == null || unencryptedString.equals(""))
			return null;

		String encryptedString = null;
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
			byte[] encryptedText = cipher.doFinal(plainText);
			encryptedString = new String(Base64.getEncoder().encode(encryptedText));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptedString;
	}

	public String decrypt(String encryptedString) {
		if (encryptedString == null || encryptedString.equals(""))
			return null;

		String decryptedText = null;
		try {
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] encryptedText = Base64.getDecoder().decode(encryptedString);
			byte[] plainText = cipher.doFinal(encryptedText);
			decryptedText = new String(plainText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decryptedText;
	}

	public static void displayText(InputStream input) throws IOException {
		// Read one text line at a time and display.
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		while (true) {
			String line = reader.readLine();
			if (line == null)
				break;
			System.out.println("    " + line);
		}
	}

	static class LazyHolder {
		public static AppUtils INSTANCE = new AppUtils();
	}
}
