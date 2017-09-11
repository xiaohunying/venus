package com.ayawala.venus.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayawala.venus.models.db.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {
	
	public Set<Request> findByRequestorId(final Long requestorId);
	
	public Set<Request> findByRealEstateId(final Long realEstateId);
}
