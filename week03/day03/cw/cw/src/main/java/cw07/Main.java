package cw07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your Word :");
        String word = input.nextLine();
        StringBuilder newWord = new StringBuilder(); // level;

        for (int i = word.length()-1; i >= 0; i--)
            newWord.append(word.charAt(i));

        if (word.contentEquals(newWord))
            System.out.println("this is palindrome");
        else
            System.out.println("this is'nt palindrome");

    }
}

