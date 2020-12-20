package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

class Noise {
    static void addNoise(File image, File output, int lvl) throws IOException {
        BufferedImage sourceImage = null;
        sourceImage = ImageIO.read(image);
        int count = ((sourceImage.getHeight() * sourceImage.getWidth()) / 100) * lvl;
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int x = random.nextInt(sourceImage.getWidth());
            int y = random.nextInt(sourceImage.getHeight());
            Color pixel = new Color(sourceImage.getRGB(x, y));
            if (pixel.getBlue() == 255 && pixel.getGreen() == 255 && pixel.getRed() == 255) i--;
            else sourceImage.setRGB(x, y, new Color(255, 255, 255).getRGB());
        }
        ImageIO.write(sourceImage, "bmp", output);
    }
}
