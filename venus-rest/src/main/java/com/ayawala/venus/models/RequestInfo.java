package com.ayawala.venus.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class RequestInfo {
	
	private Long requestId;
	
	private Long realEstateId;
	
	private Long requestorId;
	
	private Long acceptedResponseId;
	
	private Long acceptedResponsorId;
	
	private String address;
	
	private String city;
	
	private String zip;
	
	private String requestorFirstName;
	
	private String requestorLastName;
	
	private String type;
	
	private String message;
	
	private String status;
	
	private Set<ResponseInfo> responses;
	
	private Date createdDate;
	
	private Date closeDate;
	
	private Date cancelDate;
	
	public RequestInfo() {
	}

	public RequestInfo(Long requestId, Long realEstateId, Long requestorId, 
			Long acceptedResponseId, Long acceptedResponsorId,
			String address, String city, String zip, 
			String requestorFirstName, String requestorLastName, 
			String type, String message, String status, 
			Set<ResponseInfo> responses, 
			Date createdDate, Date closeDate, Date cancelDate) {
		this.requestId = requestId;
		this.realEstateId = realEstateId;
		this.requestorId = requestorId;
		this.acceptedResponseId = acceptedResponseId;
		this.acceptedResponsorId = acceptedResponsorId;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.requestorFirstName = requestorFirstName;
		this.requestorLastName = requestorLastName;
		this.type = type;
		this.message = message;
		this.status = status;
		this.responses = responses;
		this.createdDate = createdDate;
		this.closeDate = closeDate;
		this.cancelDate = cancelDate;
	}
	
	public void addResponseInfo(final Long id, final Long responsorId,
			final String responsorFirstName, final String responsorLastName,
			final String status, final String message) {
		if(responses == null) {
			responses = new HashSet<ResponseInfo>();
		}
		responses.add(new ResponseInfo(id, responsorId,
				responsorFirstName, responsorLastName,
				status, message));
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
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

	public Set<ResponseInfo> getResponses() {
		return responses;
	}

	public void setResponses(Set<ResponseInfo> responses) {
		this.responses = responses;
	}

	public Long getAcceptedResponseId() {
		return acceptedResponseId;
	}

	public void setAcceptedResponseId(Long acceptedResponseId) {
		this.acceptedResponseId = acceptedResponseId;
	}

	public Long getRequestorId() {
		return requestorId;
	}

	public void setRequestorId(Long requestorId) {
		this.requestorId = requestorId;
	}

	public String getRequestorFirstName() {
		return requestorFirstName;
	}

	public void setRequestorFirstName(String requestorFirstName) {
		this.requestorFirstName = requestorFirstName;
	}

	public String getRequestorLastName() {
		return requestorLastName;
	}

	public void setRequestorLastName(String requestorLastName) {
		this.requestorLastName = requestorLastName;
	}

	public Long getRealEstateId() {
		return realEstateId;
	}

	public void setRealEstateId(Long realEstateId) {
		this.realEstateId = realEstateId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Long getAcceptedResponsorId() {
		return acceptedResponsorId;
	}

	public void setAcceptedResponsorId(Long acceptedResponsorId) {
		this.acceptedResponsorId = acceptedResponsorId;
	}
}

class ResponseInfo {
	
	private Long id;
	
	private Long responsorId;
	
	private String responsorFirstName;
	
	private String responsorLastName;
	
	private String status;
	
	private String message;
	
	public ResponseInfo(final Long id, final Long responsorId,
			final String responsorFirstName, final String responsorLastName,
			final String status, final String message) {
		this.id = id;
		this.responsorId = responsorId;
		this.responsorFirstName = responsorFirstName;
		this.responsorLastName = responsorLastName;
		this.status = status;
		this.message = message;
	}

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

	public Long getResponsorId() {
		return responsorId;
	}

	public void setResponsorId(Long responsorId) {
		this.responsorId = responsorId;
	}

	public String getResponsorFirstName() {
		return responsorFirstName;
	}

	public void setResponsorFirstName(String responsorFirstName) {
		this.responsorFirstName = responsorFirstName;
	}

	public String getResponsorLastName() {
		return responsorLastName;
	}

	public void setResponsorLastName(String responsorLastName) {
		this.responsorLastName = responsorLastName;
	}
}
