package com.pixel.pixelproject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

/**
 * @author Andrius Baltrunas
 */
@Getter
@AllArgsConstructor
public class ProductNotFoundException extends RuntimeException {

    private final UUID id;
}
