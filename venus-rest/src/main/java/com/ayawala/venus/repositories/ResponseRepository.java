package com.ayawala.venus.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayawala.venus.models.db.Response;

public interface ResponseRepository extends JpaRepository<Response, Long> {
	
	public Set<Response> findByRequestId(final Long requestId);
}
