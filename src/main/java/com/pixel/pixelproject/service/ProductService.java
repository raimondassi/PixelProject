package com.pixel.pixelproject.service;

import com.pixel.pixelproject.Entity.Pixel;
import com.pixel.pixelproject.Entity.Product;
import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.pixel.pixelproject.service.Properties.imageHeight;
import static com.pixel.pixelproject.service.Properties.imageWidth;

@Service
public class ProductService {

    public void generatePicture() throws IOException {
        int width = 640, height = 320;

        // Create buffered image object
        BufferedImage img = null;
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        File f = null;

        // create random values pixel by pixel
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // generating values less than 256
                int a = (int) (Math.random() * 256);
                int r = (int) (Math.random() * 256);
                int g = (int) (Math.random() * 256);
                int b = (int) (Math.random() * 256);

                //pixel
                int p = (a << 24) | (r << 16) | (g << 8) | b;

                img.setRGB(x, y, p);
            }
        }

        // write image
        try {
            f = new File("C:/Users/raimo/Desktop/gfg-logo.png");
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void generateProduct(Product product) throws IOException {

//        BufferedImage img = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
//        Graphics2D graphics2D;
        ImagePlus imp = IJ.createImage("pixelImage", "png", imageWidth, imageHeight, 0);
        ImageProcessor ip = imp.getProcessor();
        List<Pixel> pixels = product.getPixels();
        //   pixels.stream().sorted(pixel->)
        for (Pixel pixel : pixels) {
            ip.setColor(Color.getColor(pixel.getColor()));
            ip.drawRect(10, 10, imp.getWidth() - 20, imp.getHeight() - 20);
        }

        int width = 640, height = 320;

        // Create buffered image object
        BufferedImage img = null;
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        File f = null;

        // create random values pixel by pixel
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // generating values less than 256
                int a = (int) (Math.random() * 256);
                int r = (int) (Math.random() * 256);
                int g = (int) (Math.random() * 256);
                int b = (int) (Math.random() * 256);

                //pixel
                int p = (a << 24) | (r << 16) | (g << 8) | b;

                img.setRGB(x, y, p);
            }
        }

        // write image
        try {
            f = new File("C:/Users/raimo/Desktop/gfg-logo.png");
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }
}


