package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Filter {
    static void filter(File image, File output, int limit) throws IOException {
        BufferedImage sourceImage = null;
        sourceImage = ImageIO.read(image);
        int width = sourceImage.getWidth();
        int height = sourceImage.getHeight();
        BufferedImage outputPicture = new BufferedImage(width, height, sourceImage.getType());

        int colorSum = 0;
        int cl = 0;
        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                for (int col = i - 1; col < i + 2; col++) {
                    for (int row = j - 1; row < j + 2; row++) {
                        if (col != i && row != j) {
                            Color color = new Color(sourceImage.getRGB(row, col));
                            cl += color.getRed();
                            colorSum += color.getRed();
                        }
                    }
                }
                Color color = new Color(sourceImage.getRGB(j, i));
                int pixelForCheckColor = color.getRed() + color.getGreen() + color.getBlue();
                if (pixelForCheckColor - (colorSum / 8) > limit) {
                    Color newColor = new Color(cl / 8, cl / 8, cl / 8);
                    outputPicture.setRGB(j, i, newColor.getRGB());
                } else
                    outputPicture.setRGB(j, i, sourceImage.getRGB(j, i));
                colorSum = 0;
                cl = 0;
            }
        }
        ImageIO.write(outputPicture, "bmp", output);
    }
}
