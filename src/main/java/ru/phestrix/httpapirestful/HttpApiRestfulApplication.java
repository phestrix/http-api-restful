package ru.phestrix.httpapirestful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class HttpApiRestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpApiRestfulApplication.class, args);
    }


}
