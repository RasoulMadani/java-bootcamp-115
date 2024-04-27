package q_06;


import java.util.Scanner;

public class ConvertBase2To10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer input = scanner.nextInt();
        int digit = 0;
        int baseTeen = 0;
        int p = 1;
        while (input > 0) {
            digit = input % 10;
            input /= 10;
            baseTeen += (digit * p);
            p *= 2;
        }
        System.out.println(baseTeen);
    }

}
