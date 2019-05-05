package com.jhutch50.resumesandwichapplication.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.jhutch50.resumesandwichapplication.entity.ResumeEntity;

public interface ResumeRepository extends CrudRepository<ResumeEntity, Long> {
	
	ResumeEntity findByid(Long id);
	
}
