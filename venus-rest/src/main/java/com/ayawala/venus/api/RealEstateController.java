package com.ayawala.venus.api;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayawala.venus.models.RealEstateInfo;
import com.ayawala.venus.models.db.RealEstate;
import com.ayawala.venus.models.db.UserProfile;
import com.ayawala.venus.services.RealEstateService;

@RestController
@RequestMapping("api")
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	
	@RequestMapping(method = RequestMethod.POST, value = "realestates",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<RealEstateInfo> getRealEstateInfos(@RequestBody UserProfile userProfile) {
		return realEstateService.getRealEstates(userProfile);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "addrealestate", 
			produces = MediaType.APPLICATION_JSON_VALUE)
    public RealEstate add(@RequestBody RealEstate realEstate) {
		return realEstateService.addRealEstate(realEstate);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "deleterealestate", 
			produces = MediaType.APPLICATION_JSON_VALUE)
    public RealEstate delete(@RequestBody RealEstate realEstate) {
		realEstateService.deleteRealEstate(realEstate);
		return realEstate;
    }

	@RequestMapping(method = RequestMethod.POST, value = "editrealestate", 
			produces = MediaType.APPLICATION_JSON_VALUE)
    public RealEstate edit(@RequestBody RealEstate realEstate) {
		return realEstateService.editRealEstate(realEstate);
    }
}
