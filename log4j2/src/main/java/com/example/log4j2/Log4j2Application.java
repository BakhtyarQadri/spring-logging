package com.example.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Log4j2Application {

	private static final String LOGGER_NAME = "'Log4j2'";
	private static final Logger log = LoggerFactory.getLogger(Log4j2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Log4j2Application.class, args);

		log.error("welcome to the {} world", LOGGER_NAME);
		log.warn("welcome to the {} world", LOGGER_NAME);
		log.info("welcome to the {} world", LOGGER_NAME);
		log.debug("welcome to the {} world", LOGGER_NAME);
		log.trace("welcome to the {} world", LOGGER_NAME);
	}

	@GetMapping("/")
	public void greeting() {
		MDC.put("user", "Bakhtyar");
		log.info("bye bye");

		MDC.clear(); // clear MDC context after use
	}

}
