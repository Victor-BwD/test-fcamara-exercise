package com.victorbwd.desafiofcamara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DesafioFcamaraApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioFcamaraApplication.class, args);
	}

}
