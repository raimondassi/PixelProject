package com.pixel.pixelproject.repository;

import com.pixel.pixelproject.Entity.Pixel;
import com.pixel.pixelproject.Entity.PixelSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PixelSizeRepository extends JpaRepository<PixelSize, Integer> {

}
