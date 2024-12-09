package com.example.moviebooking.service;
import java.util.List;

import com.example.moviebooking.entity.*;

public interface MovieService {

    Movie addMovie(Movie movie);

    Movie updateMovie(long id, Movie movie);

    boolean deleteMovie(long id);

    Movie getMovieById(long id);

    List<Movie> getAllMovies();
}