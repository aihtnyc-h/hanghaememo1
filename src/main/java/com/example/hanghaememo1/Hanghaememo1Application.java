package com.example.hanghaememo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Hanghaememo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Hanghaememo1Application.class, args);
    }

}
