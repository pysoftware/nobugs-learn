package ru.sazonov;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

public final class UserUtils {
    private UserUtils() {
    }

    public static String generateValidPassword() {
        return "Ab1!aaaa";
    }

    public static String generateValidUsername() {
        char[] allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_.".toCharArray();
        Random random = new Random();
        int minMaxLength = random.nextInt(3, 15);
        return RandomStringUtils.random(minMaxLength, 0, allowedChars.length, false, false, allowedChars, random);
    }
}
