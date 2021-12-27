package com.pixel.pixelproject.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "pixels")
@NoArgsConstructor
@Getter
public class Pixel {

    @Id
    @GeneratedValue
    private UUID uniqid;
    private int id;
    private String color;
    private int size;
    private double procentage;

    public Pixel(String color,  int size, double procentage) {
        this.color = color;
        this.procentage = procentage;
        this.size = size;
    }
}
