package com.example.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogbackApplication {

    private static final Logger log = LoggerFactory.getLogger(LogbackApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LogbackApplication.class, args);
        log.info("welcome to the Logback world");
    }

}
