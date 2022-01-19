package com.personal.apisecjdk8.service;

import java.util.List;

import com.personal.apisecjdk8.model.dto.ProfileEntityDTO;

public interface ProfileService {

	ProfileEntityDTO saveProfile(ProfileEntityDTO profile);
		
	Boolean deleteProfile(Integer id);
	
	ProfileEntityDTO getProfileById(Integer id);
	
	List<ProfileEntityDTO> getAllProfiles();
}
