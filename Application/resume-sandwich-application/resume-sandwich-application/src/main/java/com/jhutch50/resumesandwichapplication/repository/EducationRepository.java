package com.jhutch50.resumesandwichapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.jhutch50.resumesandwichapplication.entity.EducationEntity;

public interface EducationRepository extends CrudRepository<EducationEntity, Long>{

	EducationEntity findByid(Long id);
}