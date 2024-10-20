package com.kavanant.atria_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan("com.kavanant.model")
@ComponentScan("com.kavanant")
@EnableJpaRepositories("com.kavanant.repository")
public class AtriaUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtriaUserApplication.class, args);
		System.out.println("======= Atria-User Service Register With Eureka Server Sucssesfully =======");
	}

}
