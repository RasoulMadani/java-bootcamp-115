package q_05;

import java.util.Scanner;

public class SumN_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the count :");
        int count = scanner.nextInt();
        int sum = 0;
        scanner.nextLine();
        for (int i = 0; i < count; i++) {
            System.out.println("enter the :" + (i + 1) + " number");
            String input = scanner.nextLine();
            for (int j = 0; j < input.length(); j++) {
                sum += Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }
        System.out.println("sum is : " + sum);


    }
}