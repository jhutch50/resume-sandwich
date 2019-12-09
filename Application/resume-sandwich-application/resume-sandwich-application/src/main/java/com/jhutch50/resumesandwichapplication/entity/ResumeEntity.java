package com.jhutch50.resumesandwichapplication.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "Resume")
public class ResumeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private Integer resumeNumber;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<WorkExperienceEntity> workExperienceEntityList;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<EducationEntity> educationEntityList;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<SkillsEntity> skillsEntityList;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProjectsEntity> projectsEntityList;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<VolunteerExperienceEntity> volunteerExperienceEntityList;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ActivityEntity> activityEntityList;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<UserInfoEntity> userInfoEntityList;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<EthicEntity> ethicEntityList;

	public ResumeEntity() {

	}

	public ResumeEntity(@NotNull int resumeNumber) {
		this.resumeNumber = resumeNumber;
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

	public void addWorkExperienceEntity(WorkExperienceEntity workExperienceEntity) {
		if (null == workExperienceEntityList)
			workExperienceEntityList = new ArrayList<>();

		workExperienceEntityList.add(workExperienceEntity);
	}
	
	public void removeWorkExperienceEntity(WorkExperienceEntity workExperienceEntity) {
		if (null == workExperienceEntityList)
			workExperienceEntityList = new ArrayList<>();

		workExperienceEntityList.remove(workExperienceEntity);
	}
	
	public List<EthicEntity> getEthicEntityList() {
		return ethicEntityList;
	}

	public void setEthicEntityList(List<EthicEntity> ethicEntityList) {
		this.ethicEntityList = ethicEntityList;
	}

	public void addEthicEntity(EthicEntity ethicEntity) {
		if (null == ethicEntityList)
			ethicEntityList = new ArrayList<>();

		ethicEntityList.add(ethicEntity);
	}
	
	public void removeEthicEntity(EthicEntity ethicEntity) {
		if (null == ethicEntityList)
			ethicEntityList = new ArrayList<>();

		ethicEntityList.remove(ethicEntity);
	}

	public List<EducationEntity> getEducationEntityList() {
		return educationEntityList;
	}

	public void setEducationEntityList(List<EducationEntity> educationEntityList) {
		this.educationEntityList = educationEntityList;
	}

	public void addEducationEntity(EducationEntity educationEntity) {
		if (null == educationEntityList)
			educationEntityList = new ArrayList<>();

		educationEntityList.add(educationEntity);
	}

	public List<SkillsEntity> getSkillsEntityList() {
		return skillsEntityList;
	}

	public void setSkillsEntityList(List<SkillsEntity> skillsEntityList) {
		this.skillsEntityList = skillsEntityList;
	}

	public void addSkillsEntity(SkillsEntity skillsEntity) {
		if (null == skillsEntityList)
			skillsEntityList = new ArrayList<>();

		skillsEntityList.add(skillsEntity);
	}

	public List<ProjectsEntity> getProjectsEntityList() {
		return projectsEntityList;
	}

	public void setProjectsEntityList(List<ProjectsEntity> projectsEntityList) {
		this.projectsEntityList = projectsEntityList;
	}

	public void addProjectsEntity(ProjectsEntity projectsEntity) {
		if (null == projectsEntityList)
			projectsEntityList = new ArrayList<>();

		projectsEntityList.add(projectsEntity);
	}

	public List<VolunteerExperienceEntity> getVolunteerExperienceEntityList() {
		return volunteerExperienceEntityList;
	}

	public void setVolunteerExperienceEntityList(List<VolunteerExperienceEntity> volunteerExperienceEntityList) {
		this.volunteerExperienceEntityList = volunteerExperienceEntityList;
	}

	public void addVolunteerExperienceEntity(VolunteerExperienceEntity volunteerExperienceEntity) {
		if (null == volunteerExperienceEntityList)
			volunteerExperienceEntityList = new ArrayList<>();

		volunteerExperienceEntityList.add(volunteerExperienceEntity);
	}

	public List<ActivityEntity> getActivityEntityList() {
		return activityEntityList;
	}

	public void setActivityEntityList(List<ActivityEntity> activityEntityList) {
		this.activityEntityList = activityEntityList;
	}

	public void addActivityEntity(ActivityEntity activityEntity) {
		if (null == activityEntityList)
			activityEntityList = new ArrayList<>();

		activityEntityList.add(activityEntity);
	}

	public List<UserInfoEntity> getUserInfoEntityList() {
		return userInfoEntityList;
	}

	public void setUserInfoEntityList(List<UserInfoEntity> userInfoEntityList) {
		this.userInfoEntityList = userInfoEntityList;
	}

	public void addUserInfoEntity(UserInfoEntity userInfoEntity) {
		if (null == userInfoEntityList)
			userInfoEntityList = new ArrayList<>();

		userInfoEntityList.add(userInfoEntity);
	}
}
