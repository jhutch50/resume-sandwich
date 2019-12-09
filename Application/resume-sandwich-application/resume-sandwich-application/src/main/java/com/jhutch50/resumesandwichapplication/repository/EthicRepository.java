package com.jhutch50.resumesandwichapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.jhutch50.resumesandwichapplication.entity.EthicEntity;

public interface EthicRepository extends CrudRepository<EthicEntity, Long>{

	EthicEntity findByid(Long id);
}