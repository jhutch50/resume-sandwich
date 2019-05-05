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
import com.jhutch50.resumesandwichapplication.entity.SkillsEntity;
import com.jhutch50.resumesandwichapplication.model.request.SkillsRequest;
import com.jhutch50.resumesandwichapplication.model.response.SkillsResponse;
import com.jhutch50.resumesandwichapplication.repository.PageableResumeRepository;
import com.jhutch50.resumesandwichapplication.repository.ResumeRepository;
import com.jhutch50.resumesandwichapplication.repository.SkillsRepository;



@RestController
@RequestMapping(ResourceConstants.RESUME_SKILLS_V1)
@CrossOrigin
public class SkillsResource {

	@Autowired
	PageableResumeRepository pageableResumeRepository;

	@Autowired
	ResumeRepository resumeRepository;

	@Autowired
	SkillsRepository skillsRepository;

	@Autowired
	ConversionService conversionService;

	@RequestMapping(path = "/{resumeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResumeEntity> getResumeById(@PathVariable Long resumeId) {

		ResumeEntity resumeEntity = resumeRepository.findByid(resumeId);

		return new ResponseEntity<>(resumeEntity, HttpStatus.OK);
	}

	@RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<SkillsResponse> createSkills(
			@RequestBody SkillsRequest skillsRequest) {

		SkillsEntity skillsEntity = conversionService.convert(skillsRequest,
				SkillsEntity.class);
		skillsRepository.save(skillsEntity);

		ResumeEntity resumeEntity = resumeRepository.findByid(skillsRequest.getResumeId());

		resumeEntity.addSkillsEntity(skillsEntity);
		resumeRepository.save(resumeEntity);
		skillsEntity.setResumeEntity(resumeEntity);
		
		SkillsResponse skillsResponse = conversionService.convert(skillsEntity,
				SkillsResponse.class);

		return new ResponseEntity<>(skillsResponse, HttpStatus.CREATED);

	}

	@RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<SkillsResponse> updateSkills(
			@RequestBody SkillsRequest skillsRequest) {
		

		
		return new ResponseEntity<>(new SkillsResponse(), HttpStatus.OK);
	}

	@RequestMapping(path = "/{skillsId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteSkills(@PathVariable Long skillsId) {

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
