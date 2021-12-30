package com.pixel.pixelproject.service;

import com.pixel.pixelproject.dto.PixelDto;
import com.pixel.pixelproject.entity.RGBColorAndFraction;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.*;

@Service
@NoArgsConstructor
public class ImageGenerationService {

    private static final int a = 250;//Alfa
    private final int pictureHeight = 320;
    private final int pictureWidth = 1782;
    private final Color white = Color.WHITE;
    Random random = new Random();

    private List<PixelDto> hexs;
    private List<RGBColorAndFraction> rgbs;
    private BufferedImage img = new BufferedImage(pictureWidth, pictureHeight, BufferedImage.TYPE_INT_ARGB);

    public ImageGenerationService(List<PixelDto> hexs) {
        this.hexs = hexs;
        this.rgbs = convertToRGB(hexs);
    }

    public ImageGenerationService(List<PixelDto> hexs, List<RGBColorAndFraction> rgbs) {
        this.hexs = hexs;
        this.rgbs = rgbs;
    }

    public static void main(String args[]) throws IOException {

        List<PixelDto> hexs = Arrays.asList(new PixelDto(22, "#6F7EBE", 2, 35), new PixelDto(11, "#85BC51", 1, 35), new PixelDto(12, "#85529F", 1, 20), new PixelDto(31, "#36BB9F", 3, 10));
        ImageGenerationService imageGeneration = new ImageGenerationService(hexs);
        imageGeneration.generatePicture(hexs);
        try {
            File f = new File("C:\\Users\\raimo\\Desktop\\pixel\\output.png");
            ImageIO.write(imageGeneration.img, "png", f);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public List<RGBColorAndFraction> convertToRGB(List<PixelDto> hexs) {
        List<RGBColorAndFraction> rgbs = new ArrayList<>();
        for (PixelDto hex : hexs) {
            Color rgb = hex2Rgb(hex.getColor());
            rgbs.add(new RGBColorAndFraction(rgb, hex.getSize(), hex.getProcentage()));
        }
        return rgbs;
    }

    // colorStr e.g. "#FFFFFF"
    public Color hex2Rgb(String colorStr) {
        return new Color(
                Integer.valueOf(colorStr.substring(1, 3), 16),
                Integer.valueOf(colorStr.substring(3, 5), 16),
                Integer.valueOf(colorStr.substring(5, 7), 16));
    }

    public void generateWhiteBackground() {
        for (int y = 0; y < pictureHeight; y++) {
            for (int x = 0; x < pictureWidth; x++) {
                int r = white.getRed();
                int g = white.getGreen();
                int b = white.getBlue();
                int p = (a << 24) | (r << 16) | (g << 8) | b; //pixel
                img.setRGB(x, y, p);
            }
        }
    }

    public void generateFraction1(RGBColorAndFraction rgb) {
        Integer startPoint = random.nextInt(10);
        Integer frequency = rgb.getProcentage();
        for (int y = startPoint; y < pictureHeight; y++) {
            for (int x = startPoint; x < pictureWidth; x++) {
                int r = rgb.getColor().getRed(); //red
                int g = rgb.getColor().getGreen(); //green
                int b = rgb.getColor().getBlue(); //blue
                int p = (a << 24) | (r << 16) | (g << 8) | b; //pixel
                img.setRGB(x, y, p);
            }
        }
    }

    public void generateFraction2(RGBColorAndFraction rgb) {
        Integer startPoint = random.nextInt(10);
        for (int y = startPoint; y < pictureHeight; y = y + 5) {
            for (int x = startPoint; x < pictureWidth; x = x + 5) {
                int r = rgb.getColor().getRed();
                int g = rgb.getColor().getGreen();
                int b = rgb.getColor().getBlue();
                int p = (a << 24) | (r << 16) | (g << 8) | b; //pixel
                var i = 0;
                var k = 0;
                if (y < pictureHeight - 2 && x < pictureWidth - 2) {
                    img.setRGB(x, y, p);
                    img.setRGB(x + 1, y, p);
                    img.setRGB(x, y + 1, p);
                    img.setRGB(x + 1, y + 1, p);
                }
            }
        }
    }

    public void generateFraction3(RGBColorAndFraction rgb) {
        Integer startPoint = random.nextInt(10);
        for (int y = startPoint; y < pictureHeight; y = y + 10) {
            for (int x = startPoint; x < pictureWidth; x = x + 10) {
                int r = rgb.getColor().getRed();
                int g = rgb.getColor().getGreen();
                int b = rgb.getColor().getBlue();
                int p = (a << 24) | (r << 16) | (g << 8) | b; //pixel
                if (y < pictureHeight - 3 && x < pictureWidth - 3) {
                    img.setRGB(x, y, p);
                    img.setRGB(x + 1, y, p);
                    img.setRGB(x + 2, y, p);
                    img.setRGB(x, y + 1, p);
                    img.setRGB(x, y + 2, p);
                    img.setRGB(x + 1, y + 1, p);
                    img.setRGB(x + 1, y + 2, p);
                    img.setRGB(x + 2, y + 1, p);
                    img.setRGB(x + 2, y + 2, p);
                }
            }
        }
    }

    public String generatePicture(List<PixelDto> hexs) {
        List<RGBColorAndFraction> rgbs = convertToRGB(hexs);
        final ByteArrayOutputStream os = new ByteArrayOutputStream();
        generateWhiteBackground();
        for (RGBColorAndFraction rgb : rgbs) {
            if (rgb.getSize().equals(1)) {
                generateFraction1(rgb);
            }
            if (rgb.getSize().equals(2)) {
                generateFraction2(rgb);
            }
            if (rgb.getSize().equals(3)) {
                generateFraction3(rgb);
            }
        }

        try {
            ImageIO.write(img, "png", os);
            return Base64.getEncoder().encodeToString(os.toByteArray());
        } catch (final IOException ioe) {
            throw new UncheckedIOException(ioe);
        }
    }

}

