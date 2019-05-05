package com.jhutch50.resumesandwichapplication.model.response;


public class ActivityResponse {
	private Long id;

	private String clubName;

	private String title;

	private String skillsA;

	private String skillsB;

	private String skillsC;

	private String startDate;

	private String endDate;

	public ActivityResponse(String clubName, String title, String skillsB, String skillsA, String skillsC,
			String startDate, String endDate) {
		super();
		this.clubName = clubName;
		this.title = title;
		this.skillsB = skillsB;
		this.skillsA = skillsA;
		this.skillsC = skillsC;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public ActivityResponse() {
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
