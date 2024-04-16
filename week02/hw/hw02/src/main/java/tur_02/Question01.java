package tur_02;

import java.util.Arrays;
import java.util.Scanner;

public class Question01 {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        char [] charArray = str.toCharArray();
        System.out.println(Arrays.toString(charArray));
        int counter = 0;
        for (char c : charArray) {
            if (c != ' ') {
                counter++;
            }
        }

        System.out.println(counter);
//       int counter = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == ' '){
//                counter++;
//            }
//        }
//        int lengthOfStr = str.length() - counter;
//        System.out.println(lengthOfStr);
    }
}
