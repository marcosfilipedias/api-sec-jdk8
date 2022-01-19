package com.personal.apisecjdk8.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.personal.apisecjdk8.model.User;
import com.personal.apisecjdk8.model.dto.UserEntityDTO;
import com.personal.apisecjdk8.model.dto.UserViewDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

	@Mapping(source = "idProfile", target = "profile.id")
	User toEntity(UserEntityDTO dto);
	
	@Mapping(source = "profile.id", target = "idProfile")
	UserEntityDTO toDto(User entity);
	
	@Mapping(source = "profile.id", target = "idProfile")
	UserViewDTO toViewDto(User entity);	
	
}
