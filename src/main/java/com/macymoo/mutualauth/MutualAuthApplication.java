package com.macymoo.mutualauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MutualAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MutualAuthApplication.class, args);
    }


}
