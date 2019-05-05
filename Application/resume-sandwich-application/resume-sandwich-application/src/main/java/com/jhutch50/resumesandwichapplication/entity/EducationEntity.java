package com.jhutch50.resumesandwichapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Education")
public class EducationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String universityName;

	private String degree;

	private String major;

	private String concentration;

	private String city;

	private String startDate;

	private String endDate;

	private String honors;
	
	private String gpa;

	private String state;
	@ManyToOne
	private ResumeEntity resumeEntity;

	public EducationEntity(String universityName, String degree, String major, String concentration, String city,
			String startDate, String endDate, String honors, ResumeEntity resumeEntity, String gpa, String state) {
		super();
		this.universityName = universityName;
		this.degree = degree;
		this.major = major;
		this.concentration = concentration;
		this.city = city;
		this.state = state;
		this.startDate = startDate;
		this.endDate = endDate;
		this.honors = honors;
		this.resumeEntity = resumeEntity;
		this.gpa = gpa;
	}

	public EducationEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getConcentration() {
		return concentration;
	}

	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getHonors() {
		return honors;
	}

	public void setHonors(String honors) {
		this.honors = honors;
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "EducationEntity{" + "id=" + id + ", major=" + major + ", concentration=" + concentration
				+ ", universityName=" + universityName + ", degree=" + degree + ", endDate=" + endDate + ", honors="
				+ honors + ", city=" + city + ", startDate=" + startDate + "}";
	}

	public String getGpa() {
		return gpa;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
