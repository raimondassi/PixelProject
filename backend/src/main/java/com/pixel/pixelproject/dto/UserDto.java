package com.pixel.pixelproject.dto;

import com.pixel.pixelproject.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    private String username;

    public UserDto(User user) {
        username = user.getUsername();

    }
}
