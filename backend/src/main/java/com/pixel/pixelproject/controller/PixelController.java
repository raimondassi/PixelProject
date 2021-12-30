package com.pixel.pixelproject.controller;

import com.pixel.pixelproject.dto.PixelDto;
import com.pixel.pixelproject.entity.PixelSize;
import com.pixel.pixelproject.service.ImageGenerationService;
import com.pixel.pixelproject.service.OrderService;
import com.pixel.pixelproject.service.PixelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pixel.pixelproject.controller.ApiPath.*;

@RestController
@RequestMapping(ROOT)
public class PixelController {

    PixelService pixelService;
    ImageGenerationService imageGenerationService;
    OrderService orderService;

    public PixelController(PixelService pixelService, ImageGenerationService imageGenerationService, OrderService orderService) {
        this.pixelService = pixelService;
        this.imageGenerationService = imageGenerationService;
        this.orderService = orderService;
    }

    @GetMapping(PIXELSIZES)
    public List<PixelSize> getPixelSizes() {
        return pixelService.getPixelSizes();
    }

    @PostMapping(PICTURE)
    public String generatePicture(@RequestBody List<PixelDto> hexs) {
        return imageGenerationService.generatePicture(hexs);
    }

}
