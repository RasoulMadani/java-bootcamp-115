package tur_01;

import java.util.Scanner;

public class Question01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter Next number :");
            array[i] = input.nextInt();
        }
        System.out.println("print Array one :");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("\n print new Array :");
        int[] newArray = new int[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
//            System.out.print(newArray[i] + " ");
        }
        System.arraycopy(array, 0, newArray, 0, newArray.length);



    }
}
