package com.jhutch50.resumesandwichapplication.model.response;

public class SkillsResponse {
	private Long id;

	private String skillName;

	public SkillsResponse(String skillName) {
		super();
		this.skillName = skillName;
	}

	public SkillsResponse() {
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

}
