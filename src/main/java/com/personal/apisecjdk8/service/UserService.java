package com.personal.apisecjdk8.service;

import java.util.List;

import com.personal.apisecjdk8.model.dto.UserEntityDTO;
import com.personal.apisecjdk8.model.dto.UserViewDTO;

public interface UserService {

	UserViewDTO saveUser(UserEntityDTO user);
		
	Boolean deleteUser(Long id);
	
	UserViewDTO getUserById(Long id);
	
	List<UserViewDTO> getAllUsers();
		
	String getProfileByLogin(String login);

	Long getUserIdByLogin(String login);
}
