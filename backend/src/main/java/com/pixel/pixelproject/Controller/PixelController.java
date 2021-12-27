package com.pixel.pixelproject.Controller;

import com.pixel.pixelproject.Entity.*;
import com.pixel.pixelproject.service.ImageGenerationService;
import com.pixel.pixelproject.service.OrderService;
import com.pixel.pixelproject.service.PixelService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.pixel.pixelproject.Controller.ApiPath.*;

import java.awt.image.BufferedImage;
import java.util.List;

@RestController
@RequestMapping(ROOT)
public class PixelController {

    PixelService pixelService;
    ImageGenerationService imageGenerationService;
    OrderService orderService;

    @GetMapping(PIXELSIZES)
        public List<PixelSize>  getPixelSizes(){
return pixelService.getPixelSizes();
    }

    @PostMapping(PICTURE)
    public BufferedImage generatePicture(@RequestBody List<Pixel> hexs){
        return imageGenerationService.generatePicture(hexs);
    }

    @PostMapping(ORDER)
    public void generateOrder(List<Pixel> hexs, Client client){
        orderService.createOrder(hexs,client);
    }



}
