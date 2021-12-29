package com.pixel.pixelproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
//@EnableSwagger2
@SpringBootApplication
public class PixelProjectApplication {
    public static void main(String[] args) throws IOException {

        SpringApplication.run(PixelProjectApplication.class, args);

    }
}
