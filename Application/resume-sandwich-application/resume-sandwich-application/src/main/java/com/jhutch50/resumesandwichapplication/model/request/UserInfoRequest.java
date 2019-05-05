package com.jhutch50.resumesandwichapplication.model.request;

public class UserInfoRequest {

	private Long resumeId;
	private Long id;

	private String firstname;

	private String lastname;

	private String email;

	private String phone;

	private String linkedIn;

	private String gitHub;

	public UserInfoRequest() {
		super();
	}

	public UserInfoRequest(Long resumeId, Long id, String firstname, String lastname, String email, String phone,
			String linkedIn, String gitHub) {
		super();
		this.resumeId = resumeId;
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.linkedIn = linkedIn;
		this.gitHub = gitHub;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	public String getGitHub() {
		return gitHub;
	}

	public void setGitHub(String gitHub) {
		this.gitHub = gitHub;
	}

}
