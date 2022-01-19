package com.personal.apisecjdk8.service.impl;

import java.util.ArrayList;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.personal.apisecjdk8.exception.InvalidLoginException;
import com.personal.apisecjdk8.jwt.JWTUsernamePasswordAuthenticationToken;
import com.personal.apisecjdk8.jwt.TokenProvider;
import com.personal.apisecjdk8.model.User;
import com.personal.apisecjdk8.model.dto.UserAuthDTO;
import com.personal.apisecjdk8.repository.UserRepository;
import com.personal.apisecjdk8.service.LoginService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService{

	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserRepository userRepository;
	private TokenProvider tokenProvider;
	
	@Override
	public String login(String username, String password, String system) throws InvalidLoginException {
		
		User user = getUser(username);
		
		if(user != null) {
			if(Boolean.TRUE.equals(checkPassword(password, user.getPassword()))) {
				UserAuthDTO userAuth = new UserAuthDTO(user.getId(), username, password, system);
				JWTUsernamePasswordAuthenticationToken userAuthenticationToken = new JWTUsernamePasswordAuthenticationToken(username,password, new ArrayList<>());
				userAuthenticationToken.setDetails(user.getId());
				SecurityContextHolder.getContext().setAuthentication(userAuthenticationToken);
				
				return tokenProvider.createToken(userAuthenticationToken, userAuth, system, user.getProfile().getId());
			}else {
				throw new InvalidLoginException("Invalid Password!");
			}
		}else {
			throw new InvalidLoginException("Invalid Email!");
		}
	}
	
	private User getUser(String email) {
		return userRepository.findByEmail(email);
	}
	
	private Boolean checkPassword(String credentialsPassword, String userPassword) {
		return bCryptPasswordEncoder.matches(credentialsPassword, userPassword);
	}
}
