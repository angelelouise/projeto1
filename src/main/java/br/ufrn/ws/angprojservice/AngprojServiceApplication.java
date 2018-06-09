package br.ufrn.ws.angprojservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan(basePackages = {"br.ufrn.ws.angprojservice.resource"})
//@EnableJpaRepositories(basePackages = {"br.ufrn.ws.angprojservice..repository"})
public class AngprojServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngprojServiceApplication.class, args);
	}
}
