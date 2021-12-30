package com.pixel.pixelproject.repository;

import com.pixel.pixelproject.entity.Pixel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PixelRepository extends JpaRepository<Pixel, UUID> {

    Optional<Pixel> findByColorAndAndSizeAndAndProcentage(String color, Integer size, Integer procentage);

}
