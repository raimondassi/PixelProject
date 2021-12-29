package com.pixel.pixelproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUserDto {

    private String username;
    private String password;

    public CreateUserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

