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

    private ClientDto client;
    private List<PixelDto> pixels;
    private String description;
    private String picture;
    private String username;
}
