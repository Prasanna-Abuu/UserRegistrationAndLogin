package com.kavanant.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kavanant.controller.PatientController;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan("com.kavanant.model")
@ComponentScan("com.kavanant")
@EnableJpaRepositories("com.kavanant.repository")
public class PatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientApplication.class, args);
		System.out.println("======= Patient Service Register With Eureka Server Sucssesfully =======");
	}

}
