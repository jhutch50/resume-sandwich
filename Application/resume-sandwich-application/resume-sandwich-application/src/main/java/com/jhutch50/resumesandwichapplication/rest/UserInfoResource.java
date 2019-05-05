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
import com.jhutch50.resumesandwichapplication.entity.UserInfoEntity;
import com.jhutch50.resumesandwichapplication.model.request.UserInfoRequest;
import com.jhutch50.resumesandwichapplication.model.response.UserInfoResponse;
import com.jhutch50.resumesandwichapplication.repository.PageableResumeRepository;
import com.jhutch50.resumesandwichapplication.repository.ResumeRepository;
import com.jhutch50.resumesandwichapplication.repository.UserInfoRepository;



@RestController
@RequestMapping(ResourceConstants.RESUME_USERINFO_V1)
@CrossOrigin
public class UserInfoResource {

	@Autowired
	PageableResumeRepository pageableResumeRepository;

	@Autowired
	ResumeRepository resumeRepository;

	@Autowired
	UserInfoRepository userInfoRepository;

	@Autowired
	ConversionService conversionService;

	@RequestMapping(path = "/{resumeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResumeEntity> getResumeById(@PathVariable Long resumeId) {

		ResumeEntity resumeEntity = resumeRepository.findByid(resumeId);

		return new ResponseEntity<>(resumeEntity, HttpStatus.OK);
	}

	@RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UserInfoResponse> createUserInfo(
			@RequestBody UserInfoRequest userInfoRequest) {

		UserInfoEntity userInfoEntity = conversionService.convert(userInfoRequest,
				UserInfoEntity.class);
		userInfoRepository.save(userInfoEntity);

		ResumeEntity resumeEntity = resumeRepository.findByid(userInfoRequest.getResumeId());

		resumeEntity.addUserInfoEntity(userInfoEntity);
		resumeRepository.save(resumeEntity);
		userInfoEntity.setResumeEntity(resumeEntity);
		
		UserInfoResponse userInfoResponse = conversionService.convert(userInfoEntity,
				UserInfoResponse.class);

		return new ResponseEntity<>(userInfoResponse, HttpStatus.CREATED);

	}

	@RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UserInfoResponse> updateUserInfo(
			@RequestBody UserInfoRequest userInfoRequest) {
		

		
		return new ResponseEntity<>(new UserInfoResponse(), HttpStatus.OK);
	}

	@RequestMapping(path = "/{userInfoId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUserInfo(@PathVariable Long userInfoId) {

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
