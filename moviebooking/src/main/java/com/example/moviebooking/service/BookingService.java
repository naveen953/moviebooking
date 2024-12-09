package com.example.moviebooking.service;



import java.util.List;

import com.example.moviebooking.entity.*;
import com.example.moviebooking.exceptions.BookingNotFoundException;
import com.example.moviebooking.exceptions.InsufficientSeatCountException;

public interface BookingService {

    Booking createBooking(Booking booking)throws InsufficientSeatCountException;

    Booking getBookingById(Long bookingId) throws BookingNotFoundException;

    List<Booking> getAllBookings();

    boolean deleteBooking(Long bookindId);
    
    List<Booking> getBookingsByUserId(int userId);
    
    List<Booking> getBookingsByMovieId(long movieId);
    
    


}
