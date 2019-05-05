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
import com.jhutch50.resumesandwichapplication.entity.WorkExperienceEntity;
import com.jhutch50.resumesandwichapplication.model.request.WorkExperienceRequest;
import com.jhutch50.resumesandwichapplication.model.response.WorkExperienceResponse;
import com.jhutch50.resumesandwichapplication.repository.PageableResumeRepository;
import com.jhutch50.resumesandwichapplication.repository.ResumeRepository;
import com.jhutch50.resumesandwichapplication.repository.WorkExperienceRepository;



@RestController
@RequestMapping(ResourceConstants.RESUME_WORKEXPERIENCE_V1)
@CrossOrigin
public class WorkExperienceResource {

	@Autowired
	PageableResumeRepository pageableResumeRepository;

	@Autowired
	ResumeRepository resumeRepository;

	@Autowired
	WorkExperienceRepository workExperienceRepository;

	@Autowired
	ConversionService conversionService;

	@RequestMapping(path = "/{resumeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResumeEntity> getResumeById(@PathVariable Long resumeId) {

		ResumeEntity resumeEntity = resumeRepository.findByid(resumeId);

		return new ResponseEntity<>(resumeEntity, HttpStatus.OK);
	}

	@RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<WorkExperienceResponse> createWorkExperience(
			@RequestBody WorkExperienceRequest workExperienceRequest) {

		WorkExperienceEntity workExperienceEntity = conversionService.convert(workExperienceRequest,
				WorkExperienceEntity.class);
		workExperienceRepository.save(workExperienceEntity);

		ResumeEntity resumeEntity = resumeRepository.findByid(workExperienceRequest.getResumeId());

		resumeEntity.addWorkExperienceEntity(workExperienceEntity);
		resumeRepository.save(resumeEntity);
		workExperienceEntity.setResumeEntity(resumeEntity);
		
		WorkExperienceResponse workExperienceResponse = conversionService.convert(workExperienceEntity,
				WorkExperienceResponse.class);

		return new ResponseEntity<>(workExperienceResponse, HttpStatus.CREATED);

	}

	@RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<WorkExperienceResponse> updateWorkExperience(
			@RequestBody WorkExperienceRequest workExperienceRequest) {
		

		
		return new ResponseEntity<>(new WorkExperienceResponse(), HttpStatus.OK);
	}

	@RequestMapping(path = "/{workExperienceId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteWorkExperience(@PathVariable Long workExperienceId) {

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
