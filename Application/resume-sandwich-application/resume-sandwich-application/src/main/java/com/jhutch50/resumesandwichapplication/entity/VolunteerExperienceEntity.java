package com.jhutch50.resumesandwichapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VolunteerExperience")
public class VolunteerExperienceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String organization;

	private String role;

	private String startDate;

	private String endDate;

	private String city;

	private String state;

	private String skillsA;

	private String skillsB;

	private String skillsC;

	@ManyToOne
	private ResumeEntity resumeEntity;

	public VolunteerExperienceEntity(String organization, String role, String startDate, String endDate, String city,
			String state, String skillsA, String skillsB, String skillsC, ResumeEntity resumeEntity) {
		super();
		this.organization = organization;
		this.role = role;
		this.startDate = startDate;
		this.endDate = endDate;
		this.city = city;
		this.state = state;
		this.skillsA = skillsA;
		this.skillsB = skillsB;
		this.skillsC = skillsC;
		this.resumeEntity = resumeEntity;
	}

	public VolunteerExperienceEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSkillsA() {
		return skillsA;
	}

	public void setSkillsA(String skillsA) {
		this.skillsA = skillsA;
	}

	public String getSkillsB() {
		return skillsB;
	}

	public void setSkillsB(String skillsB) {
		this.skillsB = skillsB;
	}

	public String getSkillsC() {
		return skillsC;
	}

	public void setSkillsC(String skillsC) {
		this.skillsC = skillsC;
	}

	public ResumeEntity getResumeEntity() {
		return resumeEntity;
	}

	public void setResumeEntity(ResumeEntity resumeEntity) {
		this.resumeEntity = resumeEntity;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "VolunteerExperienceEntity{" + "id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", organization="
				+ organization + ", role=" + role + ", skillsA=" + skillsA + ", skillsB=" + skillsB + ", skillsC="
				+ skillsC + ", city=" + city + ", state=" + state + "}";
	}

}
