package com.mongodb.analystcandidatetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class AnalystCandidateTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnalystCandidateTestApplication.class, args);
	}

}
