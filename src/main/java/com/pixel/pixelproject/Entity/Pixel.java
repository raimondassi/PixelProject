package com.pixel.pixelproject.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "pixels")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Pixel {

    @Id
    @GeneratedValue
    private UUID id;
    private String color;
    private double procentage;
    private PixelSizes pixelSize;

}
