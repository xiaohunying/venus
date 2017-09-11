package com.ayawala.venus.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayawala.venus.models.db.RealEstate;

public interface RealEstateRepository extends JpaRepository<RealEstate, Long> {
	
	public Set<RealEstate> findByUserProfileId(final Long userProfileId);
}
