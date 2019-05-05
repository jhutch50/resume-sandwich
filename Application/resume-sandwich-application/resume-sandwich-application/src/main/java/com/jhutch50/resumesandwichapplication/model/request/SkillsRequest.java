package com.jhutch50.resumesandwichapplication.model.request;

public class SkillsRequest {
	private Long resumeId;
	private Long id;

	private String skillName;

	public SkillsRequest() {
		super();
	}

	public SkillsRequest(Long resumeId, Long id, String skillName) {
		super();
		this.resumeId = resumeId;
		this.id = id;
		this.skillName = skillName;
	}

	public Long getResumeId() {
		return resumeId;
	}

	public void setResumeId(Long resumeId) {
		this.resumeId = resumeId;
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
