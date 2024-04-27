package q_03;

import java.util.Scanner;

public class SumBigInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstNumber = scanner.nextLine();
        String secondNumber = scanner.nextLine();
        String result = "";
        int flag = secondNumber.length() > firstNumber.length() ? 2 : 1;
        int length = (flag ==2)? secondNumber.length() - firstNumber.length() :
                firstNumber.length() - secondNumber.length();
        if (flag == 1){
            secondNumber = AddZero(secondNumber, length);
        }
        if (flag ==2){
            firstNumber = AddZero(firstNumber,length);
        }
        int sum = 0;
        int add = 0;
        for (int i = firstNumber.length() -1; i >=0 ; i--) {
            sum = Integer.parseInt(String.valueOf(firstNumber.charAt(i))) +
                    Integer.parseInt(String.valueOf(secondNumber.charAt(i))) + add;
            if (sum < 10){
                result = sum + result;
                add = 0;
            }
            else {
                result =(sum% 10)+ result ;
                add = 1;
            }
        }
        System.out.println(result);

    }
    public static String AddZero(String str , int count){
        String output = str;
        for (int i = 0; i < count; i++) {
            output = "0" + output;
        }
        return output;
    }
}