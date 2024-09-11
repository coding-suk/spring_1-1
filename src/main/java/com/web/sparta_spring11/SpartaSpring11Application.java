package com.web.sparta_spring11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpartaSpring11Application {

    public static void main(String[] args) {
        SpringApplication.run(SpartaSpring11Application.class, args);
    }

}
