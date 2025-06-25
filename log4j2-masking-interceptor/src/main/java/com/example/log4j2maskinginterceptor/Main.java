package com.example.log4j2maskinginterceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;

@SpringBootApplication
public class Main {

    private final static Logger log = LoggerFactory.getLogger(Main.class);
//    private final static Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        String email1 = "j@stc.uk";
        String email2 = "jo@xyz.com";
        String email3 = "joh@intigral.net";
        String email4 = "johndoe@gmail.com";
        String email5 = "john.doe@xyz.co.sa";

        String phone1 = "961312345"; // will not masked
        String phone2 = "9613123456";
        String phone3 = "+9613123456";
        String phone4 = "201001234567";
        String phone5 = "+201001234567";
        String phone6 = "+2010012345678"; // will not masked

        log.info("email1: {}, email2: {}, email3: {}, email4: {}, email5: " + email5, email1, email2, email3, email4);
        log.info("phone1: {}, phone2: {}, phone3: {}, phone4: {}, phone5: {}, phone6: " + phone6, phone1, phone2, phone3, phone4, phone5);
    }

}
