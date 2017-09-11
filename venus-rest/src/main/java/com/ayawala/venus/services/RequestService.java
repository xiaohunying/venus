package com.ayawala.venus.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayawala.venus.models.RequestInfo;
import com.ayawala.venus.models.db.RealEstate;
import com.ayawala.venus.models.db.Request;
import com.ayawala.venus.models.db.Response;
import com.ayawala.venus.models.db.UserProfile;
import com.ayawala.venus.repositories.RealEstateRepository;
import com.ayawala.venus.repositories.RequestRepository;
import com.ayawala.venus.repositories.ResponseRepository;
import com.ayawala.venus.repositories.UserProfileRepository;

@Service
public class RequestService {
	
	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private RealEstateRepository realEstateRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	@Autowired
	private ResponseRepository responseRepository;

	public RequestInfo getRequestInfo(final Long requestId) {
		final Request request = requestRepository.findOne(requestId);
		final RealEstate realEstate = realEstateRepository.findOne(request.getRealEstateId());
		final UserProfile requestor = userProfileRepository.findOne(request.getRequestorId());
		final Set<Response> responses = responseRepository.findByRequestId(requestId);

		final RequestInfo requestInfo = new RequestInfo(request.getId(), 
				realEstate.getId(), requestor.getId(), 0L,
				request.getAcceptedResponseId(),
				realEstate.getAddress(), realEstate.getCity(), realEstate.getZip(),
				requestor.getFirstName(), requestor.getLastName(),
				request.getType(), request.getMessage(), request.getStatus(), 
				null, request.getCreatedDate(), 
				request.getCloseDate(), request.getCancelDate());
		
		for(final Response response : responses) {
			if(response.getId() == request.getAcceptedResponseId()) {
				requestInfo.setAcceptedResponsorId(response.getResponsorId());
			}
			final UserProfile responsor = userProfileRepository.findOne(response.getResponsorId());
			requestInfo.addResponseInfo(response.getId(), response.getResponsorId(), 
					responsor.getFirstName(), responsor.getLastName(), 
					response.getStatus(), response.getMessage());
		}
		
		return requestInfo;
	}
}
