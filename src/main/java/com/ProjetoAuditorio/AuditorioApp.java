package com.ProjetoAuditorio;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//Dar o path do pacote onde se encontra a interface do repository
@EnableJpaRepositories(basePackages = "com.ProjetoAuditorio.repositories")
@SpringBootApplication
public class AuditorioApp {

	public static void main(String[] args) {
		SpringApplication.run(AuditorioApp.class, args);
	}

}
