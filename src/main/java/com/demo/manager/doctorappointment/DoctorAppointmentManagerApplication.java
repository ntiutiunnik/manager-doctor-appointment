package com.demo.manager.doctorappointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DoctorAppointmentManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorAppointmentManagerApplication.class, args);
	}
}
