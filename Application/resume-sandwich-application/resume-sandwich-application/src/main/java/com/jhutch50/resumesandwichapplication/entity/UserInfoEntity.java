package com.jhutch50.resumesandwichapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "UserInfo")
public class UserInfoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstname;

	private String lastname;

	private String email;

	private String phone;

	private String linkedIn;

	private String gitHub;

	@ManyToOne
	private ResumeEntity resumeEntity;

	public UserInfoEntity(String firstname, String lastname, String phone, String email, String linkedIn,
			String gitHub, ResumeEntity resumeEntity) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.linkedIn = linkedIn;
		this.gitHub = gitHub;
		this.resumeEntity = resumeEntity;
	}

	public UserInfoEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public ResumeEntity getResumeEntity() {
		return resumeEntity;
	}

	public void setResumeEntity(ResumeEntity resumeEntity) {
		this.resumeEntity = resumeEntity;
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

	@Override
	public String toString() {
		return "UserInfoEntity{" + "id=" + id + ", phone=" + phone + ", email=" + email
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", linkedIn=" + linkedIn + ", gitHub=" + gitHub + "}";
	}

}