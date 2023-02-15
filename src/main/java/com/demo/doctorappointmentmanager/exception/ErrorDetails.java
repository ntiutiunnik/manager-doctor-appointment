package com.demo.doctorappointmentmanager.exception;

import java.util.Date;

import static com.demo.doctorappointmentmanager.util.ExceptionTokenizer.stringifyStackTrace;

public class ErrorDetails {

    private Date timestamp;

    private String message;

    private String details;

    public ErrorDetails() {
    }

    public ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = stringifyStackTrace(message);
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
