package com.jhutch50.resumesandwichapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Skills")
public class SkillsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String skillName;

	@ManyToOne
	private ResumeEntity resumeEntity;

	public SkillsEntity(String skillName, ResumeEntity resumeEntity) {
		super();
		this.skillName = skillName;
		this.resumeEntity = resumeEntity;
	}

	public SkillsEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public ResumeEntity getResumeEntity() {
		return resumeEntity;
	}

	public void setResumeEntity(ResumeEntity resumeEntity) {
		this.resumeEntity = resumeEntity;
	}

	@Override
	public String toString() {
		return "SkillsEntity{" + "id=" + id + ", skillName=" + skillName + "}";
	}

}
