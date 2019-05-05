package com.jhutch50.resumesandwichapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "WorkExperience")
public class WorkExperienceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String company;

	private String title;

	private String startDate;

	private String endDate;

	private String city;

	private String state;

	private String skillsA;

	private String skillsB;

	private String skillsC;

	@ManyToOne
	private ResumeEntity resumeEntity;

	public WorkExperienceEntity(String company, String title, String startDate, String endDate, String city,
			String state, String skillsA, String skillsB, String skillsC, ResumeEntity resumeEntity) {
		super();
		this.company = company;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.city = city;
		this.state = state;
		this.skillsA = skillsA;
		this.skillsB = skillsB;
		this.skillsC = skillsC;
		this.resumeEntity = resumeEntity;
	}

	public WorkExperienceEntity() {
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		return "WorkExperienceEntity{" + "id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", company="
				+ company + ", title=" + title + ", skillsA=" + skillsA + ", skillsB=" + skillsB + ", skillsC="
				+ skillsC + ", city=" + city + ", state=" + state + "}";
	}

}
