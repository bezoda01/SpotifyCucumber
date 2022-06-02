package utils;

import java.util.Random;

public class RandomUtils {

    public static int getRandomNumber() {
        Random r = new Random();
        return r.nextInt(9);
    }
}
