package com.personal.apisecjdk8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.apisecjdk8.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
