package com.ayawala.venus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayawala.venus.models.db.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
