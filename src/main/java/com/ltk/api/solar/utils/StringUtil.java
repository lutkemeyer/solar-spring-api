package com.ltk.api.solar.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtil {
	
	public static boolean isNotEmpty(String str) {
		return str != null && !str.isEmpty();
	}
	
	public static boolean isTrimmedNotEmpty(String str) {
		return str != null && !str.trim().isEmpty();
	}
	
}
