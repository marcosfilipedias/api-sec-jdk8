package com.personal.apisecjdk8.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.personal.apisecjdk8.mapper.UserMapper;
import com.personal.apisecjdk8.model.User;
import com.personal.apisecjdk8.model.dto.UserEntityDTO;
import com.personal.apisecjdk8.model.dto.UserViewDTO;
import com.personal.apisecjdk8.repository.UserRepository;
import com.personal.apisecjdk8.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserRepository userRepository;
	private UserMapper userMapper;
	
	@Override
	public UserViewDTO saveUser(UserEntityDTO user) {
		
		User savedUser = userMapper.toEntity(user);
		savedUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		savedUser = userRepository.saveAndFlush(savedUser);
		
		return userMapper.toViewDto(savedUser);
	}

	@Override
	public Boolean deleteUser(Long id) {
		userRepository.deleteById(id);
		return getUserById(id) == null;
	}

	@Override
	public UserViewDTO getUserById(Long id) {
		
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return userMapper.toViewDto(user.get());
		} else {
			return null;
		}
	}

	@Override
	public List<UserViewDTO> getAllUsers() {
		return userRepository.findAll().stream().map(x -> new UserViewDTO(x.getId(), x.getName(), x.getEmail(), x.getStatus(), null)).collect(Collectors.toList());
	}

	@Override
	public String getProfileByLogin(String login) {
		return userRepository.getProfileByLogin(login);
	}

	@Override
	public Long getUserIdByLogin(String login) {
		return userRepository.getUserIdByLogin(login);
	}
}
