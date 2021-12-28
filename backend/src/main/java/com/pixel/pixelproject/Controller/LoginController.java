package com.pixel.pixelproject.Controller;

import com.pixel.pixelproject.Entity.User;
import com.pixel.pixelproject.Entity.dto.UserDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pixel.pixelproject.Controller.ApiPath.LOGIN;

@RestController
@RequestMapping(LOGIN)
public class LoginController {

    @PostMapping
    public UserDto login(@AuthenticationPrincipal User user) {
        return new UserDto(user);
    }
}
