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
        String text1 = "org.postgresql.jdbc.PgConnection@6793f752"; // shouldn't be masked
        String text2 = "nmu@EP4"; // shouldn't be masked
        String text3 = "nicas47615@finfave.com";

        String phone1 = "961312345"; // shouldn't be masked
        String phone2 = "9613123456";
        String phone3 = "+9613123456";
        String phone4 = "966831044093694";
        String phone5 = "+966831044093694";
        String phone6 = "9668310440936945"; // shouldn't be masked

        String landline = "148406656";

        log.error("error msg");
        log.warn("warn msg");
        log.info("email1: {}, email2: {}, email3: {}, email4: {}, email5: {}, text1: {}, text2: {}, text3: {}", email1, email2, email3, email4, email5, text1, text2, text3);
        log.info("phone1: {}, phone2: {}, phone3: {}, phone4: {}, phone5: {}, phone6: " + phone6, phone1, phone2, phone3, phone4, phone5);
        log.info("landline: {}", landline);
        log.debug("debug msg");
        log.trace("trace msg");
    }

}
