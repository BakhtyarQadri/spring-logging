package com.example.log4j2interceptwrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

//@RestController
@SpringBootApplication
public class Log4j2InterceptWrapperApplication {

//    private final static Logger log = LoggerFactory.getLogger(WrapperApplication.class);
//    private final static Logger log = LogManager.getLogger(WrapperApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(Log4j2InterceptWrapperApplication.class, args);
//        String email = "john.doe@example.com";
//        String phone = "923173332226";
//        String landline = "0553400719";
//        log.info("email: {}, phone: {}, landline: {}", email, phone, landline);
    }

//    @GetMapping("/")
//    public void welcome() {
//        String email = "john.doe@example.com";
//        String phone = "923173332226";
//        String landline = "0553400719";
//        log.info("email: {}, phone: {}, landline: {}", email, phone, landline);
//    }

}
