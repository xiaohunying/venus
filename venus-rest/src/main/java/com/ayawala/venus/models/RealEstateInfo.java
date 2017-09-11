package com.ayawala.venus.models;

import java.util.Set;

import com.ayawala.venus.models.db.RealEstate;
import com.ayawala.venus.models.db.Request;

public class RealEstateInfo {

private RealEstate realEstate;
	
	private Set<Request> activeRequests;
	
	public RealEstateInfo(final RealEstate realEstate,
			final Set<Request> requests) {
		this.realEstate = realEstate;
		this.activeRequests = requests;
	}

	public RealEstate getRealEstate() {
		return realEstate;
	}

	public void setRealEstate(RealEstate realEstate) {
		this.realEstate = realEstate;
	}

	public Set<Request> getActiveRequests() {
		return activeRequests;
	}

	public void setActiveRequests(Set<Request> activeRequests) {
		this.activeRequests = activeRequests;
	}
}
