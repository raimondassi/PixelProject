package com.pixel.pixelproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Client client;
    @OneToMany
    private List<Pixel> pixels;
    private LocalDateTime deliveryDate;
    private LocalDateTime orderDate;
    private String description;
    private String picture;

    public Order(Client client, List<Pixel> pixels, LocalDateTime deliveryDate, LocalDateTime orderDate, String description, String picture) {
        this.client = client;
        this.pixels = pixels;
        this.deliveryDate = deliveryDate;
        this.orderDate = orderDate;
        this.description = description;
        this.picture=picture;
    }
}
