package com.pixel.pixelproject.repository;

import com.pixel.pixelproject.Entity.Pixel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PixelRepository extends JpaRepository<Pixel, UUID> {

}
