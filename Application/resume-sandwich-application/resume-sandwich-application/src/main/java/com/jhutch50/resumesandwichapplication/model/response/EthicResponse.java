package com.jhutch50.resumesandwichapplication.model.response;


public class EthicResponse {
	private Long id;

	private String ethicStatement;

	public EthicResponse(String ethicStatement) {
		super();
		this.ethicStatement = ethicStatement;
	}

	public EthicResponse() {
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

}
