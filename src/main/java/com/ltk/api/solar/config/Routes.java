package com.ltk.api.solar.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Routes {

	public static final String PREFIX = "/api";
	
	public static final String LOGIN = PREFIX + "/login";
	public static final String LOGIN_SIGNIN = "/sign-in";
	public static final String LOGIN_SIGNUP = "/sign-up";
	
}
