package com.demo.manager.doctorappointment.controller;

public interface CrudController<DTO, ID> extends GetController<DTO, ID>, PostController<DTO>, DeleteController<ID> {
}
