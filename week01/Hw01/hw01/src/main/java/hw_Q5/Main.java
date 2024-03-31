package hw_Q5;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];
        int index = 0;
        int differentMax = 0;
        int differentMin = 0;
        int differentNew = 0;
        while (true) {
            System.out.println("Please enter number");
            if (numbers[numbers.length - 1] != 0) {
                numbers = Arrays.copyOf(numbers, numbers.length * 2);
            }
            numbers[index] = input.nextInt();
//            System.out.println(Arrays.toString(numbers));
            int lengthOfNumber = numbers.length;
            for (int i = 0; i < lengthOfNumber; i++) {
                if (
                        index - 1 >= 0 && numbers[index] > numbers[index - 1]
                ) {
                    differentNew = numbers[index] - numbers[index - 1];
                    if (differentNew > differentMax) {
                        differentMax = differentNew;
                    }
                    if (differentNew < differentMin) {
                        differentMin = differentNew;
                    }
                    if (index == 1) {
                        differentMin = differentNew;
                    }
                } else if (index - 1 >= 0) {
                    differentMax = numbers[index - 1] - numbers[index];
                    if (differentNew > differentMax) {
                        differentMax = differentNew;
                    }
                    if (differentNew < differentMin) {
                        differentMin = differentNew;
                    }
                    if (index == 1) {
                        differentMin = differentNew;
                    }
                }
            }
            index++;
            System.out.println("differentMax: " + differentMax  + " differentMin: " + differentMin);

        }
    }
}