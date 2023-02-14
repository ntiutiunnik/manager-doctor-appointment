package com.demo.doctorappointmentmanager.util;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import static com.demo.doctorappointmentmanager.util.resource.RestParams.*;

public class OffsetLimitPageable extends PageRequest {

    private final int offset;

    protected OffsetLimitPageable(int offset, int limit) {
        super(offset, limit, Sort.unsorted());
        this.offset = offset;
    }

    public static OffsetLimitPageable of(HttpServletRequest httpServletRequest) {
        String offsetString = httpServletRequest.getParameter(OFFSET_PARAM);
        String limitString = httpServletRequest.getParameter(LIMIT_PARAM);

        if (StringUtils.isEmpty(offsetString)) {
            offsetString = OFFSET_VALUE;
        }

        if (StringUtils.isEmpty(limitString)) {
            limitString = LIMIT_VALUE;
        }

        int offset = Integer.parseInt(offsetString);
        int limit = Integer.parseInt(limitString);

        if (offset < 0 || limit < 0) {
            throw new IllegalArgumentException("Wrong pagination params provided");
        }

        return new OffsetLimitPageable(offset, limit);
    }

    @Override
    public long getOffset(){
        return this.offset;
    }
}