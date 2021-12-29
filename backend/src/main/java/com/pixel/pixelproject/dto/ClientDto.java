package com.pixel.pixelproject.dto;

import com.pixel.pixelproject.entity.User;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDto extends UserDto {

    private String name;
    private String surname;
    private String country;
    private String city;
    private String street;
    private String zipCode;
    private String phone;
    private String email;

}


