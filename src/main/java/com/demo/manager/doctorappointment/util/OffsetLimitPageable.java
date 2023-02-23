package com.demo.manager.doctorappointment.util;

import com.demo.manager.doctorappointment.util.resource.RestParams;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.servlet.http.HttpServletRequest;

public class OffsetLimitPageable extends PageRequest {

    private final int offset;

    protected OffsetLimitPageable(int offset, int limit) {
        super(offset, limit, Sort.by("id"));
        this.offset = offset;
    }

    public static OffsetLimitPageable of(HttpServletRequest httpServletRequest) {
        String offsetString = httpServletRequest.getParameter(RestParams.OFFSET_PARAM);
        String limitString = httpServletRequest.getParameter(RestParams.LIMIT_PARAM);

        if (StringUtils.isEmpty(offsetString)) {
            offsetString = RestParams.OFFSET_VALUE;
        }

        if (StringUtils.isEmpty(limitString)) {
            limitString = RestParams.LIMIT_VALUE;
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