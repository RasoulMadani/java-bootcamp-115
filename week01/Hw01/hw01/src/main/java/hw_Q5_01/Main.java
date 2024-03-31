package hw_Q5_01;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];
        int index = 0, differentMax = 0, differentMin = 0, differentNew = 0;
        String differentMaxStr = "",differentMinStr = "";
        while (true) {
            System.out.println("Please enter number");
            if (numbers[numbers.length - 1] != 0) {
                numbers = Arrays.copyOf(numbers, numbers.length * 2);
            }
            numbers[index] = input.nextInt();
            for (int i = 0; i <= index; i++) {
                int firstNumber = numbers[i];
                for (int j = 0; j <= index; j++) {
                    if (i != j) {
                        differentNew = numbers[i] - numbers[j];
                        if (numbers[i] < numbers[j]) {
                            differentNew = differentNew * -1;
                        }
                        if (differentNew > differentMax) {
                            differentMax = differentNew;
                            differentMaxStr = "differentMax: " + differentMax + "("+ numbers[i] +" - " + numbers[j]  +")";
                        }
                        if (differentNew < differentMin) {
                            differentMin = differentNew;
                            differentMinStr = "differentMin: " + differentMin + "("+ numbers[i] +" - " + numbers[j]  +")";
                        }
                        if (index == 1) {
                            differentMin = differentNew;
                            differentMinStr = "differentMin: " + differentMin + "("+ numbers[i] +" - " + numbers[j]  +")";
                        }

                    }
                }
            }
            index++;
            System.out.println(differentMaxStr + " " + differentMinStr);

        }
    }
}