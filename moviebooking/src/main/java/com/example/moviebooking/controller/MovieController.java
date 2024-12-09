package com.example.moviebooking.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviebooking.entity.Movie;
import com.example.moviebooking.service.MovieService;



@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieService service;

    @PostMapping
    public ResponseEntity <Movie> addMovie(@RequestBody Movie movie) {
        Movie addedMovie = service.addMovie(movie);
        if(addedMovie == null){
//            return ResponseEntity.internalServerError().build();
        	return ResponseEntity.status(500).body(null);
        }
        return ResponseEntity.status(200).body(movie);
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<Movie> update(@PathVariable long id, Movie movie){
        try {    
            return ResponseEntity.status(200).body(service.updateMovie(id, movie));
        } catch (Exception e) {
//            return ResponseEntity.internalServerError().build();
        	return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        try {
            return ResponseEntity.status(200).body(service.getAllMovies());
        } catch (Exception e) {
//            return ResponseEntity.internalServerError().build();
        	return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovieId(@PathVariable int movieId){
        Movie gettingMovie = service.getMovieById(movieId);
        if(gettingMovie == null){
//            return ResponseEntity.internalServerError().build();
        	return ResponseEntity.status(500).body(null);
        }
        return ResponseEntity.status(200).body(gettingMovie);

    } 

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Boolean> deleteMovieById(@PathVariable Long movieId){
        try {
            return ResponseEntity.status(200).body(service.deleteMovie(movieId));
        } catch (Exception e) {
//            return ResponseEntity.internalServerError().build();
        	return ResponseEntity.status(500).body(null);
        }
    }
}