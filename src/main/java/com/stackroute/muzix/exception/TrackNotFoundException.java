package com.stackroute.muzix.exception;

public class TrackNotFoundException extends Exception {


    String messge;
    public TrackNotFoundException(String message) {
        super(message);
        this.messge = message;

    }

    public TrackNotFoundException() {
    }
}
