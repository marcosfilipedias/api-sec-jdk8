package com.personal.apisecjdk8.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.personal.apisecjdk8.exception.InvalidLoginException;
import com.personal.apisecjdk8.jwt.JWTConfigurer;
import com.personal.apisecjdk8.model.dto.JwtToken;
import com.personal.apisecjdk8.service.LoginService;
import com.personal.apisecjdk8.utils.SecurityConstants;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/api/security/public/login")
@AllArgsConstructor
public class LoginController {

	public static final String USERNAME_HEADER = "email";
	public static final String KEY_HEADER = "password";
	public static final String SYSTEM = "system";
	
	private LoginService loginService;
	
	@PostMapping()
	public ResponseEntity<?> login(@RequestHeader(USERNAME_HEADER) String username, @RequestHeader(KEY_HEADER) String password, @RequestHeader(SYSTEM) String system){
		 
		try {
			String jwt = loginService.login(username, password, system);
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add(JWTConfigurer.AUTHORIZATION_HEADER, jwt);
			return new ResponseEntity<>(new JwtToken(SecurityConstants.JWT_PREFIX + jwt), httpHeaders, HttpStatus.OK);
			
		} catch (InvalidLoginException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
		
	}
}
