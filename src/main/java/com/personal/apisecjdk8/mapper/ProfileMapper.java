package com.personal.apisecjdk8.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.personal.apisecjdk8.model.Profile;
import com.personal.apisecjdk8.model.dto.ProfileEntityDTO;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
	
	ProfileMapper INSTANCE = Mappers.getMapper( ProfileMapper.class );

	Profile toEntity(ProfileEntityDTO dto);
	
	ProfileEntityDTO toDto(Profile entity);
}
