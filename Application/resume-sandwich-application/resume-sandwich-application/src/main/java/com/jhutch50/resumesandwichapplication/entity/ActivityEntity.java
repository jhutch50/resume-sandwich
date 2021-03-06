package com.jhutch50.resumesandwichapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Activity")
public class ActivityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String clubName;

	private String title;

	private String skillsA;

	private String skillsB;

	private String skillsC;

	private String startDate;

	private String endDate;

	@ManyToOne
	private ResumeEntity resumeEntity;

	public ActivityEntity(String clubName, String title, String skillsB, String skillsA, String skillsC,
			String startDate, String endDate, ResumeEntity resumeEntity) {
		super();
		this.clubName = clubName;
		this.title = title;
		this.skillsB = skillsB;
		this.skillsA = skillsA;
		this.skillsC = skillsC;
		this.startDate = startDate;
		this.endDate = endDate;
		this.resumeEntity = resumeEntity;
	}

	public ActivityEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkillsB() {
		return skillsB;
	}

	public void setSkillsB(String skillsB) {
		this.skillsB = skillsB;
	}

	public String getSkillsA() {
		return skillsA;
	}

	public void setSkillsA(String skillsA) {
		this.skillsA = skillsA;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public ResumeEntity getResumeEntity() {
		return resumeEntity;
	}

	public void setResumeEntity(ResumeEntity resumeEntity) {
		this.resumeEntity = resumeEntity;
	}

	public String getSkillsC() {
		return skillsC;
	}

	public void setSkillsC(String skillsC) {
		this.skillsC = skillsC;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "ActivityEntity{" + "id=" + id + ", skillsB=" + skillsB + ", skillsA=" + skillsA
				+ ", clubName=" + clubName + ", title=" + title + ", endDate=" + endDate  + ", skillsC=" + skillsC + ", startDate=" + startDate + "}";
	}

}
