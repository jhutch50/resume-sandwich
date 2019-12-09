package com.jhutch50.resumesandwichapplication.model.request;

public class EthicRequest {
	private Long resumeId;
	private Long id;

	private String ethicStatement;


	public EthicRequest() {
		super();
	}

	public EthicRequest(Long resumeId, Long id, String ethicStatement) {
		super();
		this.resumeId = resumeId;
		this.id = id;
		this.ethicStatement = ethicStatement;
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

	public String getEthicStatement() {
		return ethicStatement;
	}

	public void setEthicStatement(String ethicStatement) {
		this.ethicStatement = ethicStatement;
	}
	
}
