package com.demo.manager.doctorappointment.util;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;

public class RequestParamParser {

    public static Long getLongValue(HttpServletRequest httpServletRequest, String paramName) {
        if (httpServletRequest == null || StringUtils.isEmpty(paramName)) {
            return null;
        }

        String parameter = httpServletRequest.getParameter(paramName);

        return StringUtils.isEmpty(parameter) ? null : Long.parseLong(parameter);
    }
}
