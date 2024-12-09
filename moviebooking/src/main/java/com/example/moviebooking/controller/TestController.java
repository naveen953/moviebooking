package com.example.moviebooking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviebooking.entity.Movie;



@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to the Movie Booking";
    } 

    @GetMapping("/movie")

    public List<Movie> getList(){
        List<Movie> list = new ArrayList<>();
        return list;
    }

}
