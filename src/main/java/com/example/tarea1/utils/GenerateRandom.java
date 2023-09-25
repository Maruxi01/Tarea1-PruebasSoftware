package com.example.tarea1.utils;
import java.util.Random;

public class GenerateRandom {
    static Random random = new Random();

    /**
     * This method generates a random number given an array
     * @param arr array of any type
     * @return a random number
     * **/
    public static <T> int generateRandom(T[] arr) {
        int largoArr = arr.length;
        int randomNum =  random.nextInt(largoArr);
        return randomNum;
    }

    /**
     * This method generates a random price
     * @return a random price
     * **/
    public static int generateRandomPrice() {
        int MIN_PRICE = Constants.PRECIO_MIN;
        int MAX_PRICE = Constants.PRECIO_MAX;

        int randomPrice =  (random.nextInt(MAX_PRICE - MIN_PRICE)) + MIN_PRICE;
        return randomPrice;
    }
}
