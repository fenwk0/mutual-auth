package com.macymoo.mutualauth;

import com.macymoo.mutualauth.domain.Greeting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@SpringBootApplication
public class    MutualAuthApplication {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.server.port}")
    private String serverPort;


    private static final String template = "[%s][%s] Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, applicationName, serverPort, name));
    }

    public static void main(String[] args) {
        SpringApplication.run(MutualAuthApplication.class, args);
    }



}
