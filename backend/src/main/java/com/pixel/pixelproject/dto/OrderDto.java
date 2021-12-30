package com.pixel.pixelproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {

    private ClientDto client;
    private List<PixelDto> pixels;
    private String description;
    private String picture;
    private String username;
}
