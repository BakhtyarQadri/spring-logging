package com.example.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogbackApplication {

    private static final String LOGGER_NAME = "'Logback'";
    private static final Logger log = LoggerFactory.getLogger(LogbackApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LogbackApplication.class, args);
        log.error("welcome to the {} world", LOGGER_NAME);
        log.warn("welcome to the {} world", LOGGER_NAME);
        log.info("welcome to the {} world", LOGGER_NAME);
        log.debug("welcome to the {} world", LOGGER_NAME);
        log.trace("welcome to the {} world", LOGGER_NAME);
    }

}
