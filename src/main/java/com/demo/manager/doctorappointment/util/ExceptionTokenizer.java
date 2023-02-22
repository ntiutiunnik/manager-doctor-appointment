package com.demo.manager.doctorappointment.util;

public class ExceptionTokenizer {

    public static String stringifyStackTrace(String message) {
        if (message == null || message.length() < 200) {
            return message;
        }

        return message.substring(0, 200);
    }
}
