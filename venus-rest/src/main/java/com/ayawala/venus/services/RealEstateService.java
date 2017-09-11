package com.ayawala.venus.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayawala.venus.models.RealEstateInfo;
import com.ayawala.venus.models.db.RealEstate;
import com.ayawala.venus.models.db.Request;
import com.ayawala.venus.models.db.UserProfile;
import com.ayawala.venus.repositories.RealEstateRepository;
import com.ayawala.venus.repositories.RequestRepository;

@Service
public class RealEstateService {
	
	@Autowired
	private RealEstateRepository realEstateRepository;
	
	@Autowired
	private RequestRepository requestRepository;
	
	public Set<RealEstateInfo> getRealEstates(final UserProfile userProfile) {
		final Set<RealEstateInfo> realEstateInfos = new HashSet<RealEstateInfo>();
		if(userProfile != null && userProfile.getId() > 0L) {
			Set<RealEstate> realEstates =
					realEstateRepository.findByUserProfileId(userProfile.getId());
			for(RealEstate realEstate : realEstates) {
				HashSet<Request> requests = 
						(HashSet<Request>) requestRepository.findByRealEstateId(realEstate.getId());
				realEstateInfos.add(new RealEstateInfo(realEstate, requests));
			}
		}
		return realEstateInfos;
	}
	
	public RealEstate addRealEstate(final RealEstate realEstate) {
		return realEstateRepository.save(realEstate);
	}
	
	public void deleteRealEstate(final RealEstate realEstate) {
		realEstateRepository.delete(realEstate);
	}

	public RealEstate editRealEstate(final RealEstate realEstate) {
		return realEstateRepository.save(realEstate);
	}
}
