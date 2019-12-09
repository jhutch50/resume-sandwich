package com.jhutch50.resumesandwichapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Ethic")
public class EthicEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String ethicStatement;

	@ManyToOne
	private ResumeEntity resumeEntity;

	public EthicEntity(String ethicStatement, ResumeEntity resumeEntity) {
		super();
		this.ethicStatement = ethicStatement;
		this.resumeEntity = resumeEntity;
	}

	public EthicEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEthicStatement() {
		return ethicStatement;
	}

	public void setEthicStatement(String ethicStatement) {
		this.ethicStatement = ethicStatement;
	}

	public ResumeEntity getResumeEntity() {
		return resumeEntity;
	}

	public void setResumeEntity(ResumeEntity resumeEntity) {
		this.resumeEntity = resumeEntity;
	}

}
