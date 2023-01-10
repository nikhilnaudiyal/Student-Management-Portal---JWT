package com.bct.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bct.app.dto.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	boolean existsByEmail(String email);
	//Optional<User> findByEmail(String email);
	Optional<User> findByUsername(String username);
	boolean existsByUsername(String username);
}
