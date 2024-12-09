package com.example.moviebooking.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.moviebooking.entity.*;
import com.example.moviebooking.service.*;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> newBooking(@RequestBody Booking booking){
        try {
            Booking addedNewBooking = bookingService.createBooking(booking);
            return new ResponseEntity<>(addedNewBooking, HttpStatus.CREATED);
        } catch (Exception e) {
            //return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        	return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<?> getBookingById(@PathVariable long bookingId){
        try {
            Booking gettingBookingId = bookingService.getBookingById(bookingId);
            return new ResponseEntity<>(gettingBookingId, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
    
    @GetMapping
    public ResponseEntity<List<?>> getAllBooking(){
    	try {
    		List<Booking> getBookings = bookingService.getAllBookings();
    			return ResponseEntity.status(200).body(getBookings);  		
    	}catch(Exception e) {
    		return ResponseEntity.status(404).body(null);
    	}
    }
    
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<?> deleteBookingById(@PathVariable long bookingId){
    	try {
    		bookingService.deleteBooking(bookingId);
    		return ResponseEntity.status(200).body(true);
    	}catch(Exception e) {
    		return ResponseEntity.status(404).body(false);
    	}
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getAllBookingsWithUserId(@PathVariable int userId){
    	try {
    		return ResponseEntity.status(200).body(bookingService.getBookingsByUserId(userId));
    	}catch(Exception e) {
    		return ResponseEntity.status(404).body(null);
    	}
    }
    
    
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<?> getAllBookingsWithMovieId(@PathVariable long movieId){
    	try {
    		return ResponseEntity.status(200).body(bookingService.getBookingsByMovieId(movieId));
    	}catch(Exception e) {
    		return ResponseEntity.status(404).body(null);
    	}
    } 
    
}
