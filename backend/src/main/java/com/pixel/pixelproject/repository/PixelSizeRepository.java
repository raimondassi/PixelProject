package com.pixel.pixelproject.repository;

import com.pixel.pixelproject.entity.PixelSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PixelSizeRepository extends JpaRepository<PixelSize, Integer> {

}
