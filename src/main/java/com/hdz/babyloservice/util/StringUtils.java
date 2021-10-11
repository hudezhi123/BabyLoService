package com.hdz.babyloservice.util;

public class StringUtils {

	public static boolean IsEmpty(String content) {
		if (null == content || "".equals(content) || "null".equals(content)) {
			return true;
		} else {
			return false;
		}
	}
}
