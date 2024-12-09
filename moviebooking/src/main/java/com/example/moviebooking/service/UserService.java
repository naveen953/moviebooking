package com.example.moviebooking.service;
import java.util.List;

import com.example.moviebooking.entity.*;

public interface UserService {

    User registerUser(User user);
    List<User> getAllUser();
    User loginUser(User user);
    

    

}
