package com.naver.naverlogintutorial.utils;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;

public class SecureUtils {

	private static final int DEFAULT_KEY_LENGTH = 256;
	private static final int DEFAULT_ITERATIONS = 4096;
	private static final String DEFAULT_SALT = "NAVER";

	
	
	public static String getPasswordHash(String plainPassword, String username){
		byte[] hash = makeHash(plainPassword.toCharArray(), username.getBytes(), DEFAULT_ITERATIONS, DEFAULT_KEY_LENGTH);
		return Hex.encodeHexString(hash).substring(0, 40);
	}
	
	public static String getPasswordHash(String plainPassword) {
		return getPasswordHash(plainPassword, DEFAULT_SALT);
	}

	public static boolean isMatchedPassword( String plainPassword, String username, String dbPassword){
		return StringUtils.equals(getPasswordHash(plainPassword,username),dbPassword);
	}
		
	private static byte[] makeHash(final char[] password, final byte[] salt, final int iterations, final int keyLength) {

		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
			PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
			SecretKey key = skf.generateSecret(spec);
			byte[] res = key.getEncoded();
			return res;

		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	

}
