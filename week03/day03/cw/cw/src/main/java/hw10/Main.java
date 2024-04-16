package hw10;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your index of want :");
        int index = input.nextInt();

        int counter = 0;
        for (int i = 10; i < 12; i++) {
//            1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 1 0 + 1 1 + 1 2 + 1 3

            int digits = Double.valueOf(Math.log10(i)).intValue() + 1;

            for (int j = 0; j < digits; j++) {
                counter++;
                if(counter == index){

                    char number = String.valueOf(i).charAt(j); // 1 1
                    System.out.println(number);
                    return;
                }
            }

        }
//        System.out.println(counter);
    }
}

