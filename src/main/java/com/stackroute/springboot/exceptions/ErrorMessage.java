package com.stackroute.springboot.exceptions;
import lombok.Data;

@Data
public class ErrorMessage {

    private String errormessage;

    private String requestedURI;

    public void setErrormessage(String message) {
    }

    public void setRequestedURI(String requestURI) {
    }

}