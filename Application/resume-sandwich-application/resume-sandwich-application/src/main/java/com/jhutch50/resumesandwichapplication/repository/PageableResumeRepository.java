package com.jhutch50.resumesandwichapplication.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jhutch50.resumesandwichapplication.entity.ResumeEntity;

public interface PageableResumeRepository extends PagingAndSortingRepository<ResumeEntity, Long> {
	Page<ResumeEntity> findById(Long id, Pageable page);
}
