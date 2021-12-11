package com.pixel.pixelproject.Entity;

import lombok.Getter;

@Getter
public enum PixelSizes {

    SMALL(1),
    MEDIUM(2),
    LARGE(3),
    XL(4);

    private int pixelSize;

    PixelSizes(int pixelSize) {
        this.pixelSize = pixelSize;
    }

}
