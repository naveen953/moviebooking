package com.example.moviebooking.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.moviebooking.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	Optional<User>findByEmail(String email);
	Optional<User>findByPassword(String password);

}
