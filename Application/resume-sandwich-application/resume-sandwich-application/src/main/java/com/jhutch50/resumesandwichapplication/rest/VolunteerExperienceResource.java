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
import com.jhutch50.resumesandwichapplication.entity.VolunteerExperienceEntity;
import com.jhutch50.resumesandwichapplication.model.request.VolunteerExperienceRequest;
import com.jhutch50.resumesandwichapplication.model.response.VolunteerExperienceResponse;
import com.jhutch50.resumesandwichapplication.repository.PageableResumeRepository;
import com.jhutch50.resumesandwichapplication.repository.ResumeRepository;
import com.jhutch50.resumesandwichapplication.repository.VolunteerExperienceRepository;



@RestController
@RequestMapping(ResourceConstants.RESUME_VOLUNTEEREXPERIENCE_V1)
@CrossOrigin
public class VolunteerExperienceResource {

	@Autowired
	PageableResumeRepository pageableResumeRepository;

	@Autowired
	ResumeRepository resumeRepository;

	@Autowired
	VolunteerExperienceRepository volunteerExperienceRepository;

	@Autowired
	ConversionService conversionService;

	@RequestMapping(path = "/{resumeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResumeEntity> getResumeById(@PathVariable Long resumeId) {

		ResumeEntity resumeEntity = resumeRepository.findByid(resumeId);

		return new ResponseEntity<>(resumeEntity, HttpStatus.OK);
	}

	@RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<VolunteerExperienceResponse> createVolunteerExperience(
			@RequestBody VolunteerExperienceRequest volunteerExperienceRequest) {

		VolunteerExperienceEntity volunteerExperienceEntity = conversionService.convert(volunteerExperienceRequest,
				VolunteerExperienceEntity.class);
		volunteerExperienceRepository.save(volunteerExperienceEntity);

		ResumeEntity resumeEntity = resumeRepository.findByid(volunteerExperienceRequest.getResumeId());

		resumeEntity.addVolunteerExperienceEntity(volunteerExperienceEntity);
		resumeRepository.save(resumeEntity);
		volunteerExperienceEntity.setResumeEntity(resumeEntity);
		
		VolunteerExperienceResponse volunteerExperienceResponse = conversionService.convert(volunteerExperienceEntity,
				VolunteerExperienceResponse.class);

		return new ResponseEntity<>(volunteerExperienceResponse, HttpStatus.CREATED);

	}

	@RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<VolunteerExperienceResponse> updateVolunteerExperience(
			@RequestBody VolunteerExperienceRequest volunteerExperienceRequest) {
		

		
		return new ResponseEntity<>(new VolunteerExperienceResponse(), HttpStatus.OK);
	}

	@RequestMapping(path = "/{volunteerExperienceId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteVolunteerExperience(@PathVariable Long volunteerExperienceId) {

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
