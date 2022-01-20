package com.personal.apisecjdk8.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.personal.apisecjdk8.model.User;
import com.personal.apisecjdk8.model.dto.UserEntityDTO;
import com.personal.apisecjdk8.model.dto.UserViewDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

	User toEntity(UserEntityDTO dto);
	
	UserEntityDTO toDto(User entity);
	
	UserViewDTO toViewDto(User entity);	
	
}
