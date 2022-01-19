package com.personal.apisecjdk8.service;

import com.personal.apisecjdk8.exception.InvalidLoginException;

public interface LoginService {

	public String login(String username, String password, String system) throws InvalidLoginException;
}
