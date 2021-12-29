package com.pixel.pixelproject.dto;

import com.pixel.pixelproject.entity.Role;
import com.pixel.pixelproject.entity.User;
import lombok.*;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class UserDto {


    private String username;


    public UserDto(User user) {
        username = user.getUsername();

    }
}
