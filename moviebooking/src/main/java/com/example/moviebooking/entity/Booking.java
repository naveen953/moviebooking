package com.example.moviebooking.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int seatCount;
    private double totalCost;
    @ManyToOne
    @JoinColumn(name="movie_id", nullable=false)
    @JsonIgnoreProperties({"bookings"})
    private Movie movie;
    
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    @JsonIgnoreProperties({"bookings"})
    private User user;
    
    public Booking() {
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
