package com.pixel.pixelproject.Entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@NoArgsConstructor
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

    public Order(Client client, List<Pixel> pixels, LocalDateTime deliveryDate, LocalDateTime orderDate, String description) {
        this.client = client;
        this.pixels = pixels;
        this.deliveryDate = deliveryDate;
        this.orderDate = orderDate;
        this.description = description;
    }
}
