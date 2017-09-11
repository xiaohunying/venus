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
@Table(name = "USER_PROFILE")
public class UserProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phone;
	
	private String timeZone;
	
	private boolean acceptTermsOfService;

	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationTime;
	
	// Constructors
	public UserProfile() {
	}
	
	public UserProfile(final String firstName, final String lastName, 
			final String email, final String phone, 
			final String timeZone, final boolean acceptTermsOfService, 
			final Date registrationTime) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.timeZone = timeZone;
		this.acceptTermsOfService = acceptTermsOfService;
		this.registrationTime = registrationTime;
	}
	
	// Setters and Getters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public boolean isAcceptTermsOfService() {
		return acceptTermsOfService;
	}

	public void setAcceptTermsOfService(boolean acceptTermsOfService) {
		this.acceptTermsOfService = acceptTermsOfService;
	}
}
