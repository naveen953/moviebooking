package com.example.moviebooking.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moviebooking.entity.Booking;
import com.example.moviebooking.entity.Movie;
import com.example.moviebooking.exceptions.BookingNotFoundException;
import com.example.moviebooking.exceptions.InsufficientSeatCountException;
import com.example.moviebooking.entity.*;
import com.example.moviebooking.repository.BookingRepo;
import com.example.moviebooking.repository.MovieRepo;
import com.example.moviebooking.repository.UserRepo;
import com.example.moviebooking.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired(required = true)
	private BookingRepo bookingRepo;

	@Autowired(required = true)
	private MovieRepo movieRepo;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public Booking createBooking(Booking booking) throws InsufficientSeatCountException {
		 Movie movie = movieRepo.findById(booking.getMovie().getId()).orElseThrow(() -> new RuntimeException("Movie not found"));
		 User user = userRepo.findById(booking.getUser().getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
//	        Booking checkSeatCount = bookingRepo.findBySeatCount(booking.getSeatCount()).orElse(null);
	        if (booking.getSeatCount() > 50) {
	            throw new InsufficientSeatCountException("Not enough seats available. Available seats");
	        }
	        booking.setUser(user);
	        booking.setMovie(movie);
//	        booking.setSeatCount(checkSeatCount);
	        booking.setTotalCost(booking.getSeatCount() * movie.getPrice());

	        return bookingRepo.save(booking);
	    }

	@Override
	public Booking getBookingById(Long bookingId) throws BookingNotFoundException {
		Booking getBookingId = bookingRepo.findById(bookingId).orElse(null);
		if (getBookingId == null) {
			 throw new BookingNotFoundException("Booking not found");
		}
		return getBookingId;
	}

	@Override
	public List<Booking> getAllBookings() {
		return bookingRepo.findAll();
	}

	@Override
	public boolean deleteBooking(Long bookingId) {
		Booking findId = bookingRepo.findById(bookingId).orElse(null);
		if (findId == null) {
			return false;
		}

		bookingRepo.deleteById(bookingId);
		return true;
	}

	@Override
	public List<Booking> getBookingsByUserId(int userId) {
		 List<Booking> allBookings = bookingRepo.findAll();
		    List<Booking> userBookings = new ArrayList<>();

		    for (Booking booking : allBookings) {
		        if (booking.getUser().getUserId() == (userId)) {
		            userBookings.add(booking);
		        }
		    }
		    return userBookings;	
	}

	@Override
	public List<Booking> getBookingsByMovieId(long movieId) {
		  List<Booking> allBookings = bookingRepo.findAll();
		    List<Booking> movieBookings = new ArrayList<>();

		    for (Booking booking : allBookings) {
		        if (booking.getMovie().getId() == movieId) {
		            movieBookings.add(booking);
		        }
		    }
		    return movieBookings;
	}	 
}
