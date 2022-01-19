package com.personal.apisecjdk8.utils;

public class SecurityConstants {

	public static final String SECRET = "6402cf1325132fdacadasdagfgdg5354fed908cfdbeaaa7333";
	public static final long EXPIRATION_TIME = 3600000; // 5min
	public static final String COOKIE_NAME = "token";
		
	public static final String CLAIM_LOGIN = "login";
	public static final String CLAIM_DETAIL = "id";
	public static final String CLAIM_PROFILE = "Profile";
	
	public static final String HEADER_STRING = "Authorization";
	public static final String JWT_PREFIX = "Bearer ";
	
}
