package com.example.moviebooking.exceptions;

public class InsufficientSeatCountException extends Exception{

    public InsufficientSeatCountException(){
        super();
    }

    public InsufficientSeatCountException(String message){
        super(message);
    }

}
