package com.jhutch50.resumesandwichapplication.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jhutch50.resumesandwichapplication.entity.ResumeEntity;
import com.jhutch50.resumesandwichapplication.entity.ActivityEntity;
import com.jhutch50.resumesandwichapplication.model.request.ActivityRequest;
import com.jhutch50.resumesandwichapplication.model.response.DisplayResumeResponse;
import com.jhutch50.resumesandwichapplication.repository.PageableResumeRepository;
import com.jhutch50.resumesandwichapplication.repository.ResumeRepository;

import converter.ResumeEntityToDisplayResumeResponseConverter;

import com.jhutch50.resumesandwichapplication.repository.ActivityRepository;



@RestController
@RequestMapping(ResourceConstants.RESUME_DISPLAY)
@CrossOrigin
public class ResumeResource {

	@Autowired
	PageableResumeRepository pageableResumeRepository;

	@Autowired
	ResumeRepository resumeRepository;

	@Autowired
	ActivityRepository activityRepository;

	@Autowired
	ConversionService conversionService;

	   @RequestMapping(path ="", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	    public Page<DisplayResumeResponse> getResumes (
	            @RequestParam(value = "resumeNumber")
	            String resumeNumber, Pageable pageable) {

	        Page<ResumeEntity> resumeEntityList = pageableResumeRepository.findAll(pageable);

	        return resumeEntityList.map(new ResumeEntityToDisplayResumeResponseConverter() ::convert);
	    }

}
