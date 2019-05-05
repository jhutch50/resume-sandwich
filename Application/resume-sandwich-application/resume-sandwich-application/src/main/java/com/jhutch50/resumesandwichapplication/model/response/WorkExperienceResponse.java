package com.jhutch50.resumesandwichapplication.model.response;

import com.jhutch50.resumesandwichapplication.model.Links;

public class WorkExperienceResponse {

	private Long id;
	private String city;
	private String state;
	private String startDate;
	private String endDate;
	private String company;
	private String title;
	private String skillsA;
	private String skillsB;
	private String skillsC;
	private Links links;

	public WorkExperienceResponse() {
		super();
	}

	public WorkExperienceResponse(Long id, String city, String startDate, String endDate, String company, String title,
			String skillsA, String skillsB, String skillsC, Links links, String state) {
		super();
		this.id = id;
		this.city = city;
		this.startDate = startDate;
		this.endDate = endDate;
		this.company = company;
		this.title = title;
		this.skillsA = skillsA;
		this.skillsB = skillsB;
		this.skillsC = skillsC;
		this.links = links;
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
