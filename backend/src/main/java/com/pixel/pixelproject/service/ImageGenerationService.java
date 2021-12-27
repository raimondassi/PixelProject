package com.pixel.pixelproject.service;

import com.pixel.pixelproject.Entity.Pixel;
import com.pixel.pixelproject.Entity.RGBColorAndFraction;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@NoArgsConstructor
public class ImageGenerationService {

    private static final int a = 250;//Alfa
    private final int pictureHeight = 320;
    private final int pictureWidth = 640;
    private final Color white = Color.WHITE;
    private List<Pixel> hexs;
    private List<RGBColorAndFraction> rgbs;
    private BufferedImage img = new BufferedImage(pictureWidth, pictureHeight, BufferedImage.TYPE_INT_ARGB);

    public ImageGenerationService(List<Pixel> hexs) {
        this.hexs = hexs;
        this.rgbs = convertToRGB(hexs);
    }

    public ImageGenerationService(List<Pixel> hexs, List<RGBColorAndFraction> rgbs) {
        this.hexs = hexs;
        this.rgbs = rgbs;
    }

    public static void main(String args[]) throws IOException {

        List<Pixel> hexs = Arrays.asList(new Pixel("#6F7EBE", 2, 0.35), new Pixel("#85BC51", 1, 0.35), new Pixel("#85529F", 1, 0.2), new Pixel("#36BB9F", 3, 0.1));
        ImageGenerationService imageGeneration = new ImageGenerationService(hexs);
        imageGeneration.generatePicture(hexs);
        try {
            File f = new File("C:\\Users\\raimo\\Desktop\\pixel\\output.png");
            ImageIO.write(imageGeneration.img, "png", f);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public List<RGBColorAndFraction> convertToRGB(List<Pixel> hexs) {
        List<RGBColorAndFraction> rgbs = new ArrayList<>();
        for (Pixel hex : hexs) {
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

    public void generateFraction1(RGBColorAndFraction rgb) {

        for (int y = 0; y < pictureHeight; y++) {
            for (int x = 0; x < pictureWidth; x++) {
                int r = rgb.getColor().getRed(); //red
                int g = rgb.getColor().getGreen(); //green
                int b = rgb.getColor().getBlue(); //blue
                int p = (a << 24) | (r << 16) | (g << 8) | b; //pixel
                img.setRGB(x, y, p);
            }
        }
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

    public void generateFraction2(RGBColorAndFraction rgb) {

        for (int y = 0; y < pictureHeight; y++) {
            for (int x = 0; x < pictureWidth; x++) {
                    int r = rgb.getColor().getRed();
                    int g = rgb.getColor().getGreen();
                    int b = rgb.getColor().getBlue();
                    int p = (a << 24) | (r << 16) | (g << 8) | b; //pixel
                    img.setRGB(x, y, p);
                }
            }
        }


    public BufferedImage generatePicture(List<Pixel> hexs) {
        List<RGBColorAndFraction> rgbs = convertToRGB(hexs);
        generateWhiteBackground();
        for (RGBColorAndFraction rgb : rgbs) {
            if (rgb.getSize().equals(1)) {
                generateFraction1(rgb);
            }
            if (rgb.getSize().equals(2)) {
                generateFraction2(rgb);
            }

        }

        //create random image pixel by pixel
//            for(int y = 0; y < height; y++){
//                for(int x = 0; x < width; x++){
//                    int a = (int)(Math.random()*256); //alpha
//                    int r = (int)(Math.random()*256); //red
//                    int g = (int)(Math.random()*256); //green
//                    int b = (int)(Math.random()*256); //blue
//
//                    int p = (a<<24) | (r<<16) | (g<<8) | b; //pixel
//
//                    img.setRGB(x, y, p);
//                }
//            }
        //write image
        return img;

    }
}
