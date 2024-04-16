package cw02;

import java.util.Arrays;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        char[] chars = generateArrayChar(3);
        System.out.println(Arrays.toString(chars));
//        printArray(chars);

        countLetters(chars);

    }

    public static char[] generateArrayChar(int size) {
        char[] letter = new char[]{
        'c','d','d','j','j','g', 'g', 'g'
        };
//        Random rnd = new Random();
//        for (int i = 0; i < size; i++) {
//            letter[i] = (char) ('a' + rnd.nextInt(26));
//        }
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

    public  static  int[] countLetters (char[] letters){
        int[] countes = new int[26];
        for (int i = 0; i < letters.length; i++) {
//            System.out.println(letters[i]);
            int countchar = 1;
            for (int j = 0; j < letters.length; j++) {
                if(i != j){

                    if (letters[i] == letters[j]){
                        countchar++;
                         int ab= (int) (letters[i] - 'a');
                         countes[ab] = countchar;
                        System.out.println(ab);
                        System.out.println(Arrays.toString(countes));
                        System.out.println(letters[i] + " " + letters[j] + " i:" + i + " j:" + j);
                    }
                }

            }
        }
//        int[0] -> 'a' -> 2

        return countes;
    }

    public  static  void printCounts(int[] couts){
        System.out.println(
                "[a - 2]"
        );
        for (int i = 0; i < couts.length; i++) {
            System.out.println(
                    "[" + ((char) 'a'+ i ) + "-"  + couts[i] + "]"
            );
        }
    }
}