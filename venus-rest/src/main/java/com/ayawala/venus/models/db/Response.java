package com.ayawala.venus.models.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESPONSE")
public class Response {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long requestId;
	
	private Long responsorId;
	
	private String status;
	
	private String message;
	
	// Constructors
	public Response() {
	}
	
	public Response(final Long requestId, final Long responsorId,
			final String message, final String status) {
		this.requestId = requestId;
		this.setResponsorId(responsorId);
		this.status = status;
		this.message = message;
	}

	// Setters and Getters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Long getResponsorId() {
		return responsorId;
	}

	public void setResponsorId(Long responsorId) {
		this.responsorId = responsorId;
	}
}
