package com.spring.sideproject.common.utils;

import java.util.List;

import org.springframework.util.StringUtils;

public class StringHelper {

	public static boolean isEmpty(String param) {
		return StringUtils.isEmpty(param);
	}
	
	public static <T> boolean isEmpty(List<T> list) {
		if ( list == null || list.size() == 0 ) {
			return true;
		} else {
			return false;
		}
	}	
}
