package hw10;


import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your index of want :");
        int index = input.nextInt();
        int counter = 1;
        for (int i = 1; i <= 4000; i++) {
            int digits = Double.valueOf(Math.log10(i)).intValue();
            int num = i;
            while (digits >= 0) {
                int pow = (int) Math.pow(10, digits);
                int t = num / pow;
                 if(counter++ == index){
                     System.out.println(t);
                     return;
                 }
                 num = num - t*pow;
                 digits--;
            }
        }
    }
}

