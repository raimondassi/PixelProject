package com.pixel.pixelproject.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private UUID id;
    @OneToOne
    private Client client;
    @OneToMany
    private List<Product> products;
    private Date deliveryDate;
    private Date orderDate;

}
