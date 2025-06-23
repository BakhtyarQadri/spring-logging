package com.example.log4j2interceptwrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;

@RestController
@SpringBootApplication
public class Log4j2InterceptWrapperApplication {

    static String email = "john.doe@example.com";
    static String phone = "923173332226";
    static String landline = "0553400719";
    private final static Logger log = LoggerFactory.getLogger(Log4j2InterceptWrapperApplication.class);
//    private final static Logger log = LogManager.getLogger(Log4j2InterceptWrapperApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(Log4j2InterceptWrapperApplication.class, args);
        log.info("email: {}, phone: {}, landline: {}", email, phone, landline);
    }

    @GetMapping("/")
    public void welcome() {
        log.info("email: {}, phone: {}, landline: {}", email, phone, landline);
    }

}
