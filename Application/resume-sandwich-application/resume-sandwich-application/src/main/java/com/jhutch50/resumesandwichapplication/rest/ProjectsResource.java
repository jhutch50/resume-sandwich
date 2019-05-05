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
import com.jhutch50.resumesandwichapplication.entity.ProjectsEntity;
import com.jhutch50.resumesandwichapplication.model.request.ProjectsRequest;
import com.jhutch50.resumesandwichapplication.model.response.ProjectsResponse;
import com.jhutch50.resumesandwichapplication.repository.PageableResumeRepository;
import com.jhutch50.resumesandwichapplication.repository.ResumeRepository;
import com.jhutch50.resumesandwichapplication.repository.ProjectsRepository;



@RestController
@RequestMapping(ResourceConstants.RESUME_PROJECTS_V1)
@CrossOrigin
public class ProjectsResource {

	@Autowired
	PageableResumeRepository pageableResumeRepository;

	@Autowired
	ResumeRepository resumeRepository;

	@Autowired
	ProjectsRepository projectsRepository;

	@Autowired
	ConversionService conversionService;

	@RequestMapping(path = "/{resumeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResumeEntity> getResumeById(@PathVariable Long resumeId) {

		ResumeEntity resumeEntity = resumeRepository.findByid(resumeId);

		return new ResponseEntity<>(resumeEntity, HttpStatus.OK);
	}

	@RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProjectsResponse> createProjects(
			@RequestBody ProjectsRequest projectsRequest) {

		ProjectsEntity projectsEntity = conversionService.convert(projectsRequest,
				ProjectsEntity.class);
		projectsRepository.save(projectsEntity);

		ResumeEntity resumeEntity = resumeRepository.findByid(projectsRequest.getResumeId());

		resumeEntity.addProjectsEntity(projectsEntity);
		resumeRepository.save(resumeEntity);
		projectsEntity.setResumeEntity(resumeEntity);
		
		ProjectsResponse projectsResponse = conversionService.convert(projectsEntity,
				ProjectsResponse.class);

		return new ResponseEntity<>(projectsResponse, HttpStatus.CREATED);

	}

	@RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProjectsResponse> updateProjects(
			@RequestBody ProjectsRequest projectsRequest) {
		

		
		return new ResponseEntity<>(new ProjectsResponse(), HttpStatus.OK);
	}

	@RequestMapping(path = "/{projectsId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProjects(@PathVariable Long projectsId) {

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
