package com.jhutch50.resumesandwichapplication.model.request;

public class ProjectsRequest {
	private Long resumeId;
	private Long id;

	private String projectName;

	private String projectRole;

	private String skillsA;

	private String skillsB;

	private String skillsC;

	private String startDate;

	private String endDate;

	public ProjectsRequest(Long resumeId, Long id, String projectName, String projectRole, String skillsA,
			String skillsB, String skillsC, String startDate, String endDate) {
		super();
		this.resumeId = resumeId;
		this.id = id;
		this.projectName = projectName;
		this.projectRole = projectRole;
		this.skillsA = skillsA;
		this.skillsB = skillsB;
		this.skillsC = skillsC;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public ProjectsRequest() {
		super();
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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectRole() {
		return projectRole;
	}

	public void setProjectRole(String projectRole) {
		this.projectRole = projectRole;
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

}
