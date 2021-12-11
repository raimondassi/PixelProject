package com.pixel.pixelproject.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Table(name = "products")
@Getter
public class Product {

    @Id
    @GeneratedValue
    private UUID id;
    @OneToMany
    private List<Pixel> pixels;

    public Product(List<Pixel> pixels) {
        this.pixels = pixels;
    }

}
