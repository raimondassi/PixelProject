package com.pixel.pixelproject.Controller;

import com.pixel.pixelproject.Entity.PixelSize;
import com.pixel.pixelproject.service.PixelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.pixel.pixelproject.Controller.ApiPath.*;


import java.util.List;

@RestController
@RequestMapping(ROOT)
public class PixelController {

    PixelService pixelService;

    public PixelController(PixelService pixelService) {
        this.pixelService = pixelService;
    }

    @GetMapping(PIXELSIZES)
        public List<PixelSize>  getPixelSizes(){
return pixelService.getPixelSizes();
    }
}
