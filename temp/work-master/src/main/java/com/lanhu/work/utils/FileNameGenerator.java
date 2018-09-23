package com.lanhu.work.utils;

import java.util.Random;

import com.lanhu.work.security.Digests;

public class FileNameGenerator {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	
	/**
	 * 文件名称生成
	 */
	public static String generateFileName() {
		String plain = Encodes.unescapeHtml(randomStr(5)+System.currentTimeMillis());
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
		return Encodes.encodeHex(hashPassword);
	}
	
	/**
	 * 随机生成length长度的字符创
	 * @param length
	 * @return
	 */
	private static String randomStr(int length){
		Random r = new Random();
		String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<length;i++){
			buffer.append(r.nextInt(s.length()));
		}
		return buffer.toString();
	}

}
