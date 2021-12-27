package com.pixel.pixelproject.service;

import com.pixel.pixelproject.Entity.PixelSize;
import com.pixel.pixelproject.repository.PixelRepository;
import com.pixel.pixelproject.repository.PixelSizeRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class PixelService {

    PixelSizeRepository pixelRepository;

    public PixelService(PixelSizeRepository pixelRepository) {
        this.pixelRepository = pixelRepository;
    }

    public List<PixelSize> getPixelSizes(){
        return pixelRepository.findAll();
    }
}
