package com.jhutch50.resumesandwichapplication.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jhutch50.resumesandwichapplication.entity.ResumeEntity;
import com.jhutch50.resumesandwichapplication.entity.ActivityEntity;
import com.jhutch50.resumesandwichapplication.model.request.ActivityRequest;
import com.jhutch50.resumesandwichapplication.model.response.ActivityResponse;
import com.jhutch50.resumesandwichapplication.repository.PageableResumeRepository;
import com.jhutch50.resumesandwichapplication.repository.ResumeRepository;
import com.jhutch50.resumesandwichapplication.repository.ActivityRepository;



@RestController
@RequestMapping(ResourceConstants.RESUME_ACTIVITY_V1)
@CrossOrigin
public class ActivityResource {

	@Autowired
	PageableResumeRepository pageableResumeRepository;

	@Autowired
	ResumeRepository resumeRepository;

	@Autowired
	ActivityRepository activityRepository;

	@Autowired
	ConversionService conversionService;

	@RequestMapping(path = "/{resumeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResumeEntity> getResumeById(@PathVariable Long resumeId) {

		ResumeEntity resumeEntity = resumeRepository.findByid(resumeId);

		return new ResponseEntity<>(resumeEntity, HttpStatus.OK);
	}

	@RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ActivityResponse> createActivity(
			@RequestBody ActivityRequest activityRequest) {

		ActivityEntity activityEntity = conversionService.convert(activityRequest,
				ActivityEntity.class);
		activityRepository.save(activityEntity);

		ResumeEntity resumeEntity = resumeRepository.findByid(activityRequest.getResumeId());

		resumeEntity.addActivityEntity(activityEntity);
		resumeRepository.save(resumeEntity);
		activityEntity.setResumeEntity(resumeEntity);
		
		ActivityResponse activityResponse = conversionService.convert(activityEntity,
				ActivityResponse.class);

		return new ResponseEntity<>(activityResponse, HttpStatus.CREATED);

	}

	@RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ActivityResponse> updateActivity(
			@RequestBody ActivityRequest activityRequest) {
		

		
		return new ResponseEntity<>(new ActivityResponse(), HttpStatus.OK);
	}

	@RequestMapping(path = "/{activityId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteActivity(@PathVariable Long activityId) {

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
