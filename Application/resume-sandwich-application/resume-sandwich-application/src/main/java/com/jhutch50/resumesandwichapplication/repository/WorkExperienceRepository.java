package com.jhutch50.resumesandwichapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.jhutch50.resumesandwichapplication.entity.WorkExperienceEntity;

public interface WorkExperienceRepository extends CrudRepository<WorkExperienceEntity, Long>{

	WorkExperienceEntity findByid(Long id);
}
