package com.macymoo.mutualauth;

import com.macymoo.mutualauth.domain.Greeting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MutualAuthApplication {
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String serverPort;


    private static final String template = "[%s][%s] Hello, this is me :)";

    @RequestMapping("/")
    public String home() {
        String retVal = String.format(template, applicationName, serverPort);
        return retVal;
    }

    public static void main(String[] args) {
        SpringApplication.run(MutualAuthApplication.class, args);
    }


}
