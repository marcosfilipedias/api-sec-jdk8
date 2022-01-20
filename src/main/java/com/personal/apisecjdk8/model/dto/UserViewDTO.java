package com.personal.apisecjdk8.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class UserViewDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private String email;
	
	@Getter @Setter
	private Boolean status;
	
	@Getter @Setter
	private Long idProfile;

}
