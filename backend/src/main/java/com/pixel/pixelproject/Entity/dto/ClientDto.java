package com.pixel.pixelproject.Entity.dto;

import com.pixel.pixelproject.Entity.User;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDto extends User {

    private UUID id;
    private String name;
    private String surname;
    private String country;
    private String city;
    private String street;
    private String zipCode;
    private String phone;
    private String email;

}


