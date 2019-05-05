package com.jhutch50.resumesandwichapplication.model.request;

public class WorkExperienceRequest {
	private Long id;

	private Long resumeId;

	private String startDate;

	private String endDate;

	private String company;

	private String title;

	private String skillsA;

	private String skillsB;

	private String skillsC;

	private String city;

	private String state;

	public WorkExperienceRequest() {
		super();
	}

	public WorkExperienceRequest(Long id, Long resumeId, String startDate, String endDate, String company, String title,
			String skillsA, String skillsB, String skillsC, String city, String state) {
		super();
		this.id = id;
		this.resumeId = resumeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.company = company;
		this.title = title;
		this.skillsA = skillsA;
		this.skillsB = skillsB;
		this.skillsC = skillsC;
		this.city = city;
		this.state = state;
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

}
