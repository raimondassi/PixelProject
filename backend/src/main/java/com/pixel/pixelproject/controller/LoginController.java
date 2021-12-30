package com.pixel.pixelproject.controller;

import com.pixel.pixelproject.dto.UserDto;
import com.pixel.pixelproject.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pixel.pixelproject.controller.ApiPath.LOGIN;

@RestController
@RequestMapping(LOGIN)
public class LoginController {

    @PostMapping
    public UserDto login(@AuthenticationPrincipal User user) {
        return new UserDto(user);
    }
}
