package com.pixel.pixelproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.io.IOException;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PixelProjectApplication {
    public static void main(String[] args) throws IOException {

        SpringApplication.run(PixelProjectApplication.class, args);

    }
}
