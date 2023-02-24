package com.demo.manager.doctorappointment;

import com.demo.manager.doctorappointment.config.SwaggerConfigurationListener;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@OpenAPIDefinition
public class DoctorAppointmentManagerApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(DoctorAppointmentManagerApplication.class);
		springApplication.addListeners(new SwaggerConfigurationListener());
		springApplication.run(args);
	}
}
