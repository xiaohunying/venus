package com.ayawala.venus.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayawala.venus.models.RequestInfo;
import com.ayawala.venus.services.RequestService;

@RestController
@RequestMapping("api")
public class RequestController {

	@Autowired
	private RequestService requestService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/request/{id}")
    public RequestInfo add(@PathVariable Long id) {
		return requestService.getRequestInfo(id);
    }
}
