package com.pixel.pixelproject.Entity.dto;

import com.pixel.pixelproject.Entity.Client;
import com.pixel.pixelproject.Entity.Pixel;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDto {

    private Client client;
    private List<PixelDto> pixels;
    private LocalDateTime deliveryDate;
    private LocalDateTime orderDate;
    private String description;

}
