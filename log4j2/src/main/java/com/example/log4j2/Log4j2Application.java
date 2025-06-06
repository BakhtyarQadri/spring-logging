package com.example.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Log4j2Application {

	private static final Logger log = LogManager.getLogger(Log4j2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Log4j2Application.class, args);
		System.out.println("welcome to the log4j2 world");
		log.info("welcome to the log4j2 world");
	}

}
