package com.example.moviebooking.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moviebooking.entity.Movie;
import com.example.moviebooking.repository.MovieRepo;
import com.example.moviebooking.service.MovieService;



@Service
public class MovieServiceImpl implements MovieService{

    
    @Autowired(required = true)
    private MovieRepo repo;

    @Override
    public Movie addMovie(Movie movie) {
        return repo.save(movie);
    }

    @Override
    public boolean deleteMovie(long id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        } 
        return false; 
    }

    @Override
    public List<Movie> getAllMovies() {
        return repo.findAll();
    }

    @Override
    public Movie getMovieById(long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Movie updateMovie(long id, Movie movie) {
        Optional<Movie> duplicateMovie = repo.findById(id);
        if(duplicateMovie.isPresent()){
            Movie updateMovie = duplicateMovie.get();
            updateMovie.setId(movie.getId());
            updateMovie.setTitle(movie.getTitle());
            updateMovie.setDuration(movie.getDuration());
            updateMovie.setGenre(movie.getGenre());
            updateMovie.setPrice(movie.getPrice());
            return repo.save(updateMovie);
        }
        return null;
    }


}
