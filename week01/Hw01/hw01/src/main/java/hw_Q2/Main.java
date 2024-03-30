package hw_Q2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Your Number:");
        int number = input.nextInt();
        int reverse_num = 0;
        while (number>0){
            int temp = number % 10;
            reverse_num = reverse_num * 10 + temp;
            number = number / 10;
        }
        System.out.println(reverse_num);

    }
}