package com.company;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File inputImage = new File(args[0]);
        File imageWithNoise = new File(args[2]);
        File imageGrey = new File(args[1]);
        File filteredImage = new File(args[3]);
        Grey.toGrey(inputImage,imageGrey);
        Noise.addNoise(imageGrey, imageWithNoise, Integer.parseInt(args[4]));
        Filter.filter(imageWithNoise, filteredImage, Integer.parseInt(args[5]));
    }
}
