package hw_Q3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int  n;
        Scanner intput = new Scanner(System.in);

        System.out. println("Enter n:");
        n = intput.nextInt();

        for (int  i = 0; i <= n; i++) {
            for (int j = i; j < n; j++)
                System.out.print("  ");
            for (int  j = 0;  j < i; j++) {
                System.out. print(" *  ");
            }
            System.out. println("");
        }


    }
}