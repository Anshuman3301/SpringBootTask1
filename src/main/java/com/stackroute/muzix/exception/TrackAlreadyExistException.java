package com.stackroute.muzix.exception;

public class TrackAlreadyExistException extends Exception {


    String messge;
    public TrackAlreadyExistException(String message) {
        super(message);
        this.messge = message;

    }

    public TrackAlreadyExistException() {
    }
}
