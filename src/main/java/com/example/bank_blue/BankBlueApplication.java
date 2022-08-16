package com.example.bank_blue;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@AllArgsConstructor
@Configuration
public class BankBlueApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankBlueApplication.class, args);
    }

}
