package com.pixel.pixelproject.Controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pixel.pixelproject.Controller.ApiPath.ADMIN;

@RestController
@RequestMapping()
@Api(tags = "Admin controller")

public class AdminController {

    @PostMapping(ADMIN)
    public void addPersonell() {

    }

    @GetMapping()
    public void getAllProducts() {

    }

}
