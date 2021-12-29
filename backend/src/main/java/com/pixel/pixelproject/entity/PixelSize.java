package com.pixel.pixelproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "pixelsize")
public class PixelSize {

    @Id
    @GeneratedValue
    private int id;
    private int pixelSize;

}
