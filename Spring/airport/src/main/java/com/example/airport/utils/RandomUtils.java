package com.example.airport.utils;

import java.util.Random;

public class RandomUtils {

    private static Random random = new Random();
    private static String alphabet = "ABCDEF";

    public static String randomString(int l) {

        String risultato = "";
        for (int i = 0; i < l; i++) {

            char c = alphabet.charAt(random.nextInt(alphabet.length()));
            risultato = c + risultato;
        }
        return risultato;
    }

}
