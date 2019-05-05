package com.jhutch50.resumesandwichapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.jhutch50.resumesandwichapplication.entity.ProjectsEntity;

public interface ProjectsRepository extends CrudRepository<ProjectsEntity, Long>{

	ProjectsEntity findByid(Long id);
}