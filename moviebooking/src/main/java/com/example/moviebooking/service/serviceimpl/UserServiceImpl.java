package com.example.moviebooking.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.moviebooking.entity.User;
import com.example.moviebooking.repository.UserRepo;
import com.example.moviebooking.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired(required = true)
	private UserRepo userRepo;

//	@Autowired(required = true)
//	private PasswordEncoder passwordEncoder;

	@Override
	public User registerUser(User user) {
        if (userRepo.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("User Already Exists");
        }
       // user.setPassword(passwordEncoder.encode(user.getPassword()));		
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User loginUser(User user) {
		User foundUser = userRepo.findByEmail(user.getEmail())
				.orElseThrow(() -> new RuntimeException("User not found"));
//		 if (!passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
//	             throw new RuntimeException("Invalid Password");
//	        }
	       return foundUser;
	}
}
