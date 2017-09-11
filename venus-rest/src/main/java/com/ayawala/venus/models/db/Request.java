package com.ayawala.venus.models.db;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "REQUEST")
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long realEstateId;
	
	private Long requestorId;
	
	private Long acceptedResponseId;
		
	private String type;
	
	private String status;
	
	private String message;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	private Date closeDate;
	
	private Date cancelDate;
	
	public Request() {
	}
	
	public Request(final String type, final String status, 
			final String message, final Date createdDate,
			final Long realEstateId, final Long requestorId) {
		this.realEstateId = realEstateId;
		this.requestorId = requestorId;
		this.type = type;
		this.status = status;
		this.message = message;
		this.createdDate = createdDate;
	}
	
	public Request(final Long id, final Long realEstateId,
			final Long requestorId, final Long acceptedResponseId,
			final String type, final String status, final String message, 
			final Date createdDate, final Date closeDate,
			final Date cancelDate) {
		this.id = id;
		this.realEstateId = realEstateId;
		this.requestorId = requestorId;
		this.acceptedResponseId = acceptedResponseId;
		this.type = type;
		this.status = status;
		this.message = message;
		this.createdDate = createdDate;
		this.closeDate = closeDate;
		this.cancelDate = cancelDate;
	}
	
	// Setters and Getters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getRealEstateId() {
		return realEstateId;
	}

	public void setRealEstateId(Long realEstateId) {
		this.realEstateId = realEstateId;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public Long getRequestorId() {
		return requestorId;
	}

	public void setRequestorId(Long requestorId) {
		this.requestorId = requestorId;
	}

	public Long getAcceptedResponseId() {
		return acceptedResponseId;
	}

	public void setAcceptedResponseId(Long acceptedResponseId) {
		this.acceptedResponseId = acceptedResponseId;
	}
}
