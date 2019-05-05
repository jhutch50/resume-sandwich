package com.jhutch50.resumesandwichapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.jhutch50.resumesandwichapplication.entity.UserInfoEntity;

public interface UserInfoRepository extends CrudRepository<UserInfoEntity, Long>{

	UserInfoEntity findByid(Long id);
}