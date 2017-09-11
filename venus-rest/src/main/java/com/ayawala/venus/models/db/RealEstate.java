package com.ayawala.venus.models.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REAL_ESTATE")
public class RealEstate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long userProfileId;
	
	private String name;
	
	private String address;
	
	private String city;
	
	private String zip;
	
	// Constructors
	public RealEstate() {
	}
	
	public RealEstate(final String name, final String address, final String city, 
			final String zip, final Long userProfileId) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.userProfileId = userProfileId;
	}

	// Setters and Getters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}
}
