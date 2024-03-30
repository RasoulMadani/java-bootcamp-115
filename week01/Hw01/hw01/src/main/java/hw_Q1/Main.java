package hw_Q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Your Salary:");
        int salary = input.nextInt();
        double tax = 0;
        if (salary <= 3000000) {
             tax = (salary * 5) / 100;
        } else if (salary >= 6000000) {
             tax = (salary * 24) / 100;
        } else if (salary < 6000000) {
             tax = (salary * 10) / 100;
        }
        System.out.println(tax + " Toman");
    }
}