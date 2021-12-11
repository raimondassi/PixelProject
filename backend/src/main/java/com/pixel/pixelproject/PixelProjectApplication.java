package com.pixel.pixelproject;

import com.pixel.pixelproject.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class PixelProjectApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(PixelProjectApplication.class, args);
        ProductService productService = new ProductService();
//        productService.generatePicture();
        // productService.generateProduct();
    }
}
