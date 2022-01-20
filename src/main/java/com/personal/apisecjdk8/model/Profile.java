package com.personal.apisecjdk8.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PROFILE")
@AllArgsConstructor
@NoArgsConstructor
public class Profile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1776701799970579386L;

	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	
	@Column(name = "NAME")
	@Getter @Setter private String name;

	@OneToMany(mappedBy = "profile")
	private List<Profile> profile;
}
