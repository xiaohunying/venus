package com.ayawala.venus.config;

import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ayawala.venus.models.db.RealEstate;
import com.ayawala.venus.models.db.Request;
import com.ayawala.venus.models.db.Response;
import com.ayawala.venus.models.db.UserProfile;
import com.ayawala.venus.repositories.RealEstateRepository;
import com.ayawala.venus.repositories.RequestRepository;
import com.ayawala.venus.repositories.ResponseRepository;
import com.ayawala.venus.repositories.UserProfileRepository;

@Configuration
public class Seed {
	
	@Bean
	public CommandLineRunner seedDatabase(final RealEstateRepository realEstateRepository,
			final UserProfileRepository userProfileRepository,
			final RequestRepository requestRepository,
			final ResponseRepository responseRepository) {
		return args -> {
			final UserProfile userProfile1 = userProfileRepository.save(new UserProfile("Liping",
					"Wu", "lw@gmail.com", "9378700023","New York", true, 
					(new SimpleDateFormat("MM/dd/yyyy")).parse("10/10/2016")));
			final UserProfile userProfile2 = userProfileRepository.save(new UserProfile("Shawn",
					"Zachrich", "sz@gmail.com", "4123456915","New York", true, 
					(new SimpleDateFormat("MM/dd/yyyy")).parse("10/11/2016")));
			final UserProfile userProfile3 = userProfileRepository.save(new UserProfile("Chris",
					"K", "ck@gmail.com", "1112223333","New York", true, 
					(new SimpleDateFormat("MM/dd/yyyy")).parse("10/12/2016")));
			
			final RealEstate realEstate1 = realEstateRepository.save(new RealEstate("Home",
					"4321 Blacksmith Dr.", "Westerville, OH", "43081", userProfile1.getId()));
			final RealEstate realEstate2 = realEstateRepository.save(new RealEstate("Parents' Home",
					"1234 Sawmill Commons Rd.", "Dublin, OH", "43026", userProfile1.getId()));
			final RealEstate realEstate3 = realEstateRepository.save(new RealEstate("Columbus",
					"165 E Tompkins St", "Columbus, OH", "43202", userProfile2.getId()));
			
			final Request request1 = requestRepository.save(new Request("Mow Lawn", "Open",
					"asap", (new SimpleDateFormat("MM/dd/yyyy")).parse("07/15/2017"),
					realEstate1.getId(), userProfile1.getId()));
			final Request request2 = requestRepository.save(new Request("Fix Roof", "Open",
					"asap", (new SimpleDateFormat("MM/dd/yyyy")).parse("07/17/2017"),
					realEstate1.getId(), userProfile1.getId()));
			final Request request3 = requestRepository.save(new Request("Mow Lawn", "Open",
					"asap", (new SimpleDateFormat("MM/dd/yyyy")).parse("07/20/2017"),
					realEstate2.getId(), userProfile1.getId()));
			
			final Response response1 = responseRepository.save(new Response(request1.getId(),
					userProfile3.getId(), "I'm interested.", "active"));
			final Response response2 = responseRepository.save(new Response(request1.getId(),
					userProfile2.getId(), "I'm interested 2.", "active"));
		};
	}
	
}
