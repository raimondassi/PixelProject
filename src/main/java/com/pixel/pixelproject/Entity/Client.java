package com.pixel.pixelproject.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "clients")
@NoArgsConstructor
public class Client extends User {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;
    private String country;
    private String city;
    private String street;
    private String zipCode;
    private String phone;
    private String email;

    public Client(String loginName, String password, String repeatPassword, String name, String surname, String country, String city, String street, String zipCode, String phone, String email, Set<RoleName> roles) {
        super(loginName, password, repeatPassword);
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.phone = phone;
        this.email = email;

    }

}
