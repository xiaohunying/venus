package com.ayawala.venus.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayawala.venus.exception.NotFoundException;
import com.ayawala.venus.models.db.UserProfile;
import com.ayawala.venus.services.login.LoginService;

@RestController
@RequestMapping("api")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
		
	@RequestMapping(method = RequestMethod.POST, value = "login", 
			produces = MediaType.APPLICATION_JSON_VALUE)
    public UserProfile login(@RequestHeader Map<String,String> headers) {
		final String username = headers.get("username");
		final String password = headers.get("password");
		final UserProfile userProfile = loginService.login(username, password);
		if(userProfile != null) {
			return userProfile;
		} else {
			throw new NotFoundException();
		}
    }

	@RequestMapping(method = RequestMethod.POST, value = "/register")
    public String register() {
		// TODO
        return "";
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String logout() {
		// TODO
        return "";
    }
}
