package com.jhutch50.resumesandwichapplication.model.response;

public class ProjectsResponse {
	private Long id;

	private String projectName;

	private String projectRole;

	private String skillsA;

	private String skillsB;

	private String skillsC;

	private String startDate;

	private String endDate;

	public ProjectsResponse(String projectName, String projectRole, String skillsB, String skillsA, String skillsC,
			String startDate, String endDate) {
		super();
		this.projectName = projectName;
		this.projectRole = projectRole;
		this.skillsB = skillsB;
		this.skillsA = skillsA;
		this.skillsC = skillsC;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public ProjectsResponse() {
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

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

}
