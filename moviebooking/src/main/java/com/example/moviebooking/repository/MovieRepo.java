package com.example.moviebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.moviebooking.entity.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {

}
