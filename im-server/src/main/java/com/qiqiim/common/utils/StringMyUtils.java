package com.qiqiim.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 字符串工具类
 * @author LiChunhua
 * 2016-06-29
 */
public class StringMyUtils {

	/**--tostrong--**/
	public static String toString(Object obj) {
		return obj == null ? "" : obj.toString();
	}

	public static String ObjToJson(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String result = "";
		try {
			result = mapper.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	public static String getUserNumber() {
		return getUserNumber(9);
	}

	public static String getUserNumber(int size) {
		Random rm = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; i++) {
			int number = rm.nextInt(10);
			if (i == 0 && number == 0) {//
				number = rm.nextInt(9) + 1;
			}
			sb.append(number);
		}
		return sb.toString();
	}

	public static String fomatStringFloat(float f) {
		String formatString = String.format("%.2f", f);
		return formatString;
	}
	
	public static void main(String[] args) {
		System.out.println(StringMyUtils.ObjToJson(""));
	}
}
