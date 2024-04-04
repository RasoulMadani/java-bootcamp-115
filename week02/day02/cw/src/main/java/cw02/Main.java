package cw02;

import java.util.Arrays;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        char[] chars = generateArrayChar(35);
        System.out.println(Arrays.toString(chars));
        printArray(chars);
    }

    public static char[] generateArrayChar(int size) {
        char[] letter = new char[size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            letter[i] = (char) ('a' + rnd.nextInt(26));
        }
        return letter;
    }

    public static void printArray(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(chars[i] + " ");
        }
    }
}