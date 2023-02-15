package com.demo.doctorappointmentmanager.util;

import org.apache.commons.lang3.StringUtils;

public class ExceptionTokenizer {
    public static String stringifyStackTrace(String message) {
        if (StringUtils.isEmpty(message)) {
            return message;
        }

        if (message.length() < 200) {
            return message;
        }

        return message.substring(0, 200);
    }
}
