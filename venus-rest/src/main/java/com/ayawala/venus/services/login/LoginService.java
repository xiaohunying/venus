package com.ayawala.venus.services.login;

import org.springframework.stereotype.Service;

import com.ayawala.venus.models.db.UserProfile;
import com.ayawala.venus.repositories.UserProfileRepository;

@Service
public class LoginService {
	
	private UserProfileRepository userProfileRepository;
	
	public LoginService(final UserProfileRepository userProfileRepository) {
		this.userProfileRepository = userProfileRepository;
	}

	public UserProfile login(final String username, final String password) {
		final Long userProfileId = authenticate(username, password);
		return getUserProfile(userProfileId);
	}
	
	public UserProfile getUserProfile(final Long userProfileId) {
		if(userProfileId > 0) {
			return userProfileRepository.findOne(userProfileId);
		} else {
			return null;
		}
	}
	
	private Long authenticate(final String username, final String password) {
		// TODO
		if("user1".equals(username)) {
			return 1L;
		} else if("user2".equals(username)) {
			return 2L;
		} else if("user3".equals(username)) {
			return 3L;
		} else {
			return 0L;
		}
	}
}
