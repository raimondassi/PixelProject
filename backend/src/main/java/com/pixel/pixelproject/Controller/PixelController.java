package com.pixel.pixelproject.Controller;

import com.pixel.pixelproject.Entity.*;
import com.pixel.pixelproject.Entity.dto.OrderDto;
import com.pixel.pixelproject.Entity.dto.PixelDto;
import com.pixel.pixelproject.service.ImageGenerationService;
import com.pixel.pixelproject.service.OrderService;
import com.pixel.pixelproject.service.PixelService;
import org.springframework.web.bind.annotation.*;

import static com.pixel.pixelproject.Controller.ApiPath.*;

import java.util.List;

@RestController
//@RequestMapping(ROOT)
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
        public List<PixelSize>  getPixelSizes(){
return pixelService.getPixelSizes();
    }

    @PostMapping(PICTURE)
    public String generatePicture(@RequestBody List<PixelDto> hexs){
        return imageGenerationService.generatePicture(hexs);
    }

    @PostMapping(ORDER)
    public void generateOrder(OrderDto orderDto){
        orderService.createOrder(orderDto);
    }



}
