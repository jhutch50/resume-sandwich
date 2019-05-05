package com.jhutch50.resumesandwichapplication.model.request;

public class VolunteerExperienceRequest {

	private Long resumeId;
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

	public VolunteerExperienceRequest() {
		super();
	}

	public VolunteerExperienceRequest(Long resumeId, Long id, String organization, String role, String startDate,
			String endDate, String city, String state, String skillsA, String skillsB, String skillsC) {
		super();
		this.resumeId = resumeId;
		this.id = id;
		this.organization = organization;
		this.role = role;
		this.startDate = startDate;
		this.endDate = endDate;
		this.city = city;
		this.state = state;
		this.skillsA = skillsA;
		this.skillsB = skillsB;
		this.skillsC = skillsC;
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
	
}
