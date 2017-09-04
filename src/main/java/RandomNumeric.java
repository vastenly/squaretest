
package main.java;

import java.util.Random;

public class RandomNumeric {

    private final static Random random = new Random();

    public static int getRandomInt(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}