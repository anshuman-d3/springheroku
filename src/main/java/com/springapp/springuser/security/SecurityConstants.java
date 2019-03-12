package com.springapp.springuser.security;

public class SecurityConstants {
    public static final String SECRET = "hMs4PoU1t5jL36vRhdj0aAT";
    public static final long EXPIRATION_TIME = 259_200_000; // 3 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/register";
//    public static final String FRONT_END_SERVER = "http://localhost:3000";
}