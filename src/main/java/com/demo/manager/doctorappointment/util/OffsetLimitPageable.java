package com.demo.manager.doctorappointment.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import static com.demo.manager.doctorappointment.util.resource.RestParams.LIMIT_VALUE;
import static com.demo.manager.doctorappointment.util.resource.RestParams.OFFSET_VALUE;

public class OffsetLimitPageable extends PageRequest {

    private final int offset;

    protected OffsetLimitPageable(int offset, int limit) {
        super(offset, limit, Sort.by("id"));
        this.offset = offset;
    }

    public static OffsetLimitPageable of(Integer offset, Integer limit) {
        if (offset == null) {
            offset = OFFSET_VALUE;
        }

        if (limit == null) {
            limit = LIMIT_VALUE;
        }

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