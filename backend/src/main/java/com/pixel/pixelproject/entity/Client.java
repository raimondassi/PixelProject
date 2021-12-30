package com.pixel.pixelproject.entity;

import com.pixel.pixelproject.dto.ClientDto;
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

    public Client(ClientDto clientDto, User user) {
        this.user = user;
        this.name = clientDto.getName();
        this.surname = clientDto.getSurname();
        this.country = clientDto.getCountry();
        this.city = clientDto.getCity();
        this.street = clientDto.getStreet();
        this.zipCode = clientDto.getZipCode();
        this.phone = clientDto.getPhone();
        this.email = clientDto.getEmail();
    }
}
