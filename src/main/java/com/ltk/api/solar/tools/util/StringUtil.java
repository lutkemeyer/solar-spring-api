package com.ltk.api.solar.tools.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtil extends StringUtils {
	
	public static boolean ne(String str) {
		return str != null && !str.isEmpty();
	}
	
	public static boolean trimmedNe(String str) {
		return str != null && !str.trim()
				.isEmpty();
	}
	
	public static int countWords(String phrase) {
		if(phrase == null || phrase.isEmpty()) {
			return 0;
		}
		int wordCount = 0;
		boolean isWord = false;
		int endOfLine = phrase.length() - 1;
		char[] characters = phrase.toCharArray();
		for(int i = 0; i < characters.length; i++) {
			if(Character.isLetter(characters[i]) && i != endOfLine) {
				isWord = true;
			} else if(!Character.isLetter(characters[i]) && isWord) {
				wordCount++;
				isWord = false;
			} else if(Character.isLetter(characters[i]) && i == endOfLine) {
				wordCount++;
			}
		}
		return wordCount;
	}
	
}
				
