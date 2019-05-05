package com.jhutch50.resumesandwichapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.jhutch50.resumesandwichapplication.entity.SkillsEntity;

public interface SkillsRepository extends CrudRepository<SkillsEntity, Long>{

	SkillsEntity findByid(Long id);
}