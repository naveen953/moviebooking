package com.example.moviebooking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.moviebooking.entity.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long>{
//	List<Booking> findByUserId(int userId); 
//	List<Booking> findByMovieId(long movieId);
	Optional<Booking>findBySeatCount(int seatCount);
}
