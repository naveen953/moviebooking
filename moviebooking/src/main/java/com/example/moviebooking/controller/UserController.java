package com.example.moviebooking.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviebooking.entity.User;
import com.example.moviebooking.service.UserService;



@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        try {
        	userService.registerUser(user);
            return ResponseEntity.status(201).body("User Registered Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

     @PostMapping("/login")
     public ResponseEntity<?> loginUser(@RequestBody User user){
    	 try {
    		User loggedInUser = userService.loginUser(user);
    		return new ResponseEntity<>("LogIn successfully with username: "+loggedInUser.getUsername(), HttpStatus.OK);
    	 }catch(Exception e) {
    		 return ResponseEntity.status(404).body(e.getMessage());
    	 }
     }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        try {
            return ResponseEntity.status(200).body(userService.getAllUser());
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    } 
}
