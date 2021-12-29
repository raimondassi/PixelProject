package com.pixel.pixelproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "clients")
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    @OneToOne
    private User user;
    private String name;
    private String surname;
    private String country;
    private String city;
    private String street;
    private String zipCode;
    private String phone;
    private String email;

//    public Client(String loginName, String password, String name, String surname, String country, String city, String street, String zipCode, String phone, String email) {
//        super(loginName, password);
//        this.name = name;
//        this.surname = surname;
//        this.country = country;
//        this.city = city;
//        this.street = street;
//        this.zipCode = zipCode;
//        this.phone = phone;
//        this.email = email;
//
//    }

}
