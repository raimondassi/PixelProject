package com.pixel.pixelproject.controller;

import com.pixel.pixelproject.dto.CreateUserDto;
import com.pixel.pixelproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.pixel.pixelproject.controller.ApiPath.CREATEUSER;
import static com.pixel.pixelproject.controller.ApiPath.ROOT;

@RestController
@RequestMapping(ROOT + CREATEUSER)
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody CreateUserDto createUserDto) {
        userService.createNewUser(createUserDto);
    }

}
