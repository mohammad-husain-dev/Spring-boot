package com.dilshad.springstandalone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringStandaloneApplication {

    public static void main(String[] args) {
        System.out.println("Starting Spring StandaloneApplication");
        SpringApplication.run(SpringStandaloneApplication.class, args);
        System.out.println("Spring StandaloneApplication started");
    }
}
