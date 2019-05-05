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
import com.jhutch50.resumesandwichapplication.entity.EducationEntity;
import com.jhutch50.resumesandwichapplication.model.request.EducationRequest;
import com.jhutch50.resumesandwichapplication.model.response.EducationResponse;
import com.jhutch50.resumesandwichapplication.repository.PageableResumeRepository;
import com.jhutch50.resumesandwichapplication.repository.ResumeRepository;
import com.jhutch50.resumesandwichapplication.repository.EducationRepository;



@RestController
@RequestMapping(ResourceConstants.RESUME_EDUCATION_V1)
@CrossOrigin
public class EducationResource {

	@Autowired
	PageableResumeRepository pageableResumeRepository;

	@Autowired
	ResumeRepository resumeRepository;

	@Autowired
	EducationRepository educationRepository;

	@Autowired
	ConversionService conversionService;

	@RequestMapping(path = "/{resumeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResumeEntity> getResumeById(@PathVariable Long resumeId) {

		ResumeEntity resumeEntity = resumeRepository.findByid(resumeId);

		return new ResponseEntity<>(resumeEntity, HttpStatus.OK);
	}

	@RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<EducationResponse> createEducation(
			@RequestBody EducationRequest educationRequest) {

		EducationEntity educationEntity = conversionService.convert(educationRequest,
				EducationEntity.class);
		educationRepository.save(educationEntity);

		ResumeEntity resumeEntity = resumeRepository.findByid(educationRequest.getResumeId());

		resumeEntity.addEducationEntity(educationEntity);
		resumeRepository.save(resumeEntity);
		educationEntity.setResumeEntity(resumeEntity);
		
		EducationResponse educationResponse = conversionService.convert(educationEntity,
				EducationResponse.class);

		return new ResponseEntity<>(educationResponse, HttpStatus.CREATED);

	}

	@RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<EducationResponse> updateEducation(
			@RequestBody EducationRequest educationRequest) {
		

		
		return new ResponseEntity<>(new EducationResponse(), HttpStatus.OK);
	}

	@RequestMapping(path = "/{educationId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEducation(@PathVariable Long educationId) {

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
