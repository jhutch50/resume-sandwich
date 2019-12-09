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
import com.jhutch50.resumesandwichapplication.entity.EthicEntity;
import com.jhutch50.resumesandwichapplication.model.request.EthicRequest;
import com.jhutch50.resumesandwichapplication.model.response.EthicResponse;
import com.jhutch50.resumesandwichapplication.repository.PageableResumeRepository;
import com.jhutch50.resumesandwichapplication.repository.ResumeRepository;
import com.jhutch50.resumesandwichapplication.repository.EthicRepository;



@RestController
@RequestMapping(ResourceConstants.RESUME_ETHIC_V1)
@CrossOrigin
public class EthicResource {

	@Autowired
	PageableResumeRepository pageableResumeRepository;

	@Autowired
	ResumeRepository resumeRepository;

	@Autowired
	EthicRepository ethicRepository;

	@Autowired
	ConversionService conversionService;

	@RequestMapping(path = "/{resumeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResumeEntity> getResumeById(@PathVariable Long resumeId) {

		ResumeEntity resumeEntity = resumeRepository.findByid(resumeId);

		return new ResponseEntity<>(resumeEntity, HttpStatus.OK);
	}

	@RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<EthicResponse> createEthic(
			@RequestBody EthicRequest ethicRequest) {

		EthicEntity ethicEntity = conversionService.convert(ethicRequest,
				EthicEntity.class);
		ethicRepository.save(ethicEntity);

		ResumeEntity resumeEntity = resumeRepository.findByid(ethicRequest.getResumeId());

		resumeEntity.addEthicEntity(ethicEntity);
		resumeRepository.save(resumeEntity);
		ethicEntity.setResumeEntity(resumeEntity);
		
		EthicResponse ethicResponse = conversionService.convert(ethicEntity,
				EthicResponse.class);

		return new ResponseEntity<>(ethicResponse, HttpStatus.CREATED);

	}

	@RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<EthicResponse> updateEthic(
			@RequestBody EthicRequest ethicRequest) {
		

		
		return new ResponseEntity<>(new EthicResponse(), HttpStatus.OK);
	}

	@RequestMapping(path = "/{ethicId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEthic(@PathVariable Long ethicId) {

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
