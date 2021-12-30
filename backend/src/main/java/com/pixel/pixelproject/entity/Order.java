package com.pixel.pixelproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
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
