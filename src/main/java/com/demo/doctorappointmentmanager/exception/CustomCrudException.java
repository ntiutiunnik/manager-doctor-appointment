package com.demo.doctorappointmentmanager.exception;

public class CustomCrudException extends RuntimeException {

    public CustomCrudException(String message) {
        super(message);
    }
}
