package com.personal.apisecjdk8.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class UserAuthDTO {
		
	@Getter @Setter private Long id;
	 
	@Getter @Setter private String login;
		 
	@Getter @Setter private String senha;

	@Getter @Setter private String sistema;

}
