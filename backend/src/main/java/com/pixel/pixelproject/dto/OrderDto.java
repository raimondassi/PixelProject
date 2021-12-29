package com.pixel.pixelproject.dto;

import com.pixel.pixelproject.entity.Client;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {

    private Client client;
    private List<PixelDto> pixels;
    private LocalDateTime deliveryDate;
    private LocalDateTime orderDate;
    private String description;

}
