package com.demo.manager.doctorappointment.controller;

import com.demo.manager.doctorappointment.exception.CustomCrudException;
import com.demo.manager.doctorappointment.exception.ErrorDetails;
import com.demo.manager.doctorappointment.exception.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ControllerAdvice {
    private static final Logger logger = LogManager.getLogger(ControllerAdvice.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        return handleException(exception, webRequest, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomCrudException.class)
    public ResponseEntity<?> handleCustomCrudException(CustomCrudException exception, WebRequest webRequest) {
        return handleException(exception, webRequest, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            HttpMessageConversionException.class,
            TypeMismatchException.class
    })
    public ResponseEntity<?> handleDataConversionException(Exception exception, WebRequest webRequest) {
        return handleException(exception, webRequest, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception exception, WebRequest webRequest) {
        return handleException(exception, webRequest, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<?> handleException(Exception exception, WebRequest webRequest, HttpStatus httpStatus) {
        String message = exception.getMessage();
        logger.error(message);

        return new ResponseEntity<>(new ErrorDetails(new Date(), message, webRequest.getDescription(false)), httpStatus);
    }
}
