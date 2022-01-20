package com.personal.apisecjdk8.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8623263590606186788L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Getter private Long id;
	
	@Column(name = "NAME")
	@Getter @Setter private String name;
	
	@Column(name = "EMAIL")
	@Getter @Setter private String email;
	
	@Column(name = "PASSWORD")
	@Getter @Setter private String password;
	
	@Column(name = "STATUS")
	@Getter @Setter private Boolean status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PROFILE")
	@Getter @Setter private Profile profile;

}
