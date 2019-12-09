package com.jhutch50.resumesandwichapplication.model.response;

import java.util.List;

import com.jhutch50.resumesandwichapplication.entity.ActivityEntity;
import com.jhutch50.resumesandwichapplication.entity.EducationEntity;
import com.jhutch50.resumesandwichapplication.entity.ProjectsEntity;
import com.jhutch50.resumesandwichapplication.entity.SkillsEntity;
import com.jhutch50.resumesandwichapplication.entity.UserInfoEntity;
import com.jhutch50.resumesandwichapplication.entity.VolunteerExperienceEntity;
import com.jhutch50.resumesandwichapplication.entity.WorkExperienceEntity;
import com.jhutch50.resumesandwichapplication.entity.EthicEntity;
import com.jhutch50.resumesandwichapplication.model.Links;

public class DisplayResumeResponse {

	private Long id;

	private Integer resumeNumber;

	private List<WorkExperienceEntity> workExperienceEntityList;
	
	private List<EthicEntity> ethicEntityList;

	private List<EducationEntity> educationEntityList;

	private List<SkillsEntity> skillsEntityList;

	private List<ProjectsEntity> projectsEntityList;

	private List<VolunteerExperienceEntity> volunteerExperienceEntityList;

	private List<ActivityEntity> activityEntityList;

	private List<UserInfoEntity> userInfoEntityList;
	
	private Links links;

	public DisplayResumeResponse(Integer resumeNumber, List<WorkExperienceEntity> workExperienceEntityList,
			List<EducationEntity> educationEntityList, List<SkillsEntity> skillsEntityList,
			List<ProjectsEntity> projectsEntityList, List<VolunteerExperienceEntity> volunteerExperienceEntityList,
			List<ActivityEntity> activityEntityList, List<UserInfoEntity> userInfoEntityList, List<EthicEntity> ethicEntityList, Links links) {
		super();
		this.resumeNumber = resumeNumber;
		this.ethicEntityList = ethicEntityList;
		this.workExperienceEntityList = workExperienceEntityList;
		this.educationEntityList = educationEntityList;
		this.skillsEntityList = skillsEntityList;
		this.projectsEntityList = projectsEntityList;
		this.volunteerExperienceEntityList = volunteerExperienceEntityList;
		this.activityEntityList = activityEntityList;
		this.userInfoEntityList = userInfoEntityList;
		this.links = links;
	}

	public DisplayResumeResponse() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getResumeNumber() {
		return resumeNumber;
	}

	public void setResumeNumber(Integer resumeNumber) {
		this.resumeNumber = resumeNumber;
	}

	public List<WorkExperienceEntity> getWorkExperienceEntityList() {
		return workExperienceEntityList;
	}

	public void setWorkExperienceEntityList(List<WorkExperienceEntity> workExperienceEntityList) {
		this.workExperienceEntityList = workExperienceEntityList;
	}

	public List<EducationEntity> getEducationEntityList() {
		return educationEntityList;
	}

	public void setEducationEntityList(List<EducationEntity> educationEntityList) {
		this.educationEntityList = educationEntityList;
	}

	public List<SkillsEntity> getSkillsEntityList() {
		return skillsEntityList;
	}

	public void setSkillsEntityList(List<SkillsEntity> skillsEntityList) {
		this.skillsEntityList = skillsEntityList;
	}

	public List<ProjectsEntity> getProjectsEntityList() {
		return projectsEntityList;
	}

	public void setProjectsEntityList(List<ProjectsEntity> projectsEntityList) {
		this.projectsEntityList = projectsEntityList;
	}

	public List<VolunteerExperienceEntity> getVolunteerExperienceEntityList() {
		return volunteerExperienceEntityList;
	}

	public void setVolunteerExperienceEntityList(List<VolunteerExperienceEntity> volunteerExperienceEntityList) {
		this.volunteerExperienceEntityList = volunteerExperienceEntityList;
	}

	public List<ActivityEntity> getActivityEntityList() {
		return activityEntityList;
	}

	public void setActivityEntityList(List<ActivityEntity> activityEntityList) {
		this.activityEntityList = activityEntityList;
	}
	
	public List<EthicEntity> getEthicEntityList() {
		return ethicEntityList;
	}

	public void setEthicEntityList(List<EthicEntity> ethicEntityList) {
		this.ethicEntityList = ethicEntityList;
	}

	public List<UserInfoEntity> getUserInfoEntityList() {
		return userInfoEntityList;
	}

	public void setUserInfoEntityList(List<UserInfoEntity> userInfoEntityList) {
		this.userInfoEntityList = userInfoEntityList;
	}

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}
	
	
	
}