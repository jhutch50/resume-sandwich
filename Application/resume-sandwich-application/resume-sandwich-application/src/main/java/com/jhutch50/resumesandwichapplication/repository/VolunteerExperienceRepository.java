package com.jhutch50.resumesandwichapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.jhutch50.resumesandwichapplication.entity.VolunteerExperienceEntity;

public interface VolunteerExperienceRepository extends CrudRepository<VolunteerExperienceEntity, Long>{

	VolunteerExperienceEntity findByid(Long id);
}