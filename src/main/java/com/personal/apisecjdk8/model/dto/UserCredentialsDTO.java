package com.personal.apisecjdk8.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class UserCredentialsDTO {
	
	@Getter @Setter
	private String email;
	
	@Getter @Setter
	private String password;
	
	@Getter @Setter
	private String system;

}
