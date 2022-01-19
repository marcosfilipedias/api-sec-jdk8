package com.personal.apisecjdk8.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.personal.apisecjdk8.mapper.ProfileMapper;
import com.personal.apisecjdk8.model.Profile;
import com.personal.apisecjdk8.model.dto.ProfileEntityDTO;
import com.personal.apisecjdk8.repository.ProfileRepository;
import com.personal.apisecjdk8.service.ProfileService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfileServiceImpl implements ProfileService{

	private ProfileRepository profileRepository;
	private ProfileMapper profileMapper;

	@Override
	public ProfileEntityDTO saveProfile(ProfileEntityDTO profile) {
		Profile savedProfile = profileRepository.saveAndFlush(profileMapper.toEntity(profile));
		return profileMapper.toDto(savedProfile);
	}

	@Override
	public Boolean deleteProfile(Integer id) {
		profileRepository.deleteById(id);
		return getProfileById(id) == null;
	}

	@Override
	public ProfileEntityDTO getProfileById(Integer id) {
		
		Optional<Profile> profile = profileRepository.findById(id);
		if(profile.isPresent()) {
			return profileMapper.toDto(profile.get());
		} else {
			return null;
		}
	}

	@Override
	public List<ProfileEntityDTO> getAllProfiles() {
		return profileRepository.findAll().stream().map(x -> new ProfileEntityDTO(x.getId(), x.getName())).collect(Collectors.toList());
	}
	
}
