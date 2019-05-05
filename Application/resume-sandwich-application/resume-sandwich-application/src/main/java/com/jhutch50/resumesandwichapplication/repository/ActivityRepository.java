package com.jhutch50.resumesandwichapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.jhutch50.resumesandwichapplication.entity.ActivityEntity;

public interface ActivityRepository extends CrudRepository<ActivityEntity, Long>{

	ActivityEntity findByid(Long id);
}