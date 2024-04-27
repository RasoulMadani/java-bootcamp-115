package q_07;

import java.util.Scanner;

public class KMM_BMM {

    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);

        int first_num = input.nextInt();
        int second_num = input.nextInt();

        int min1 = 1;
        int min2 = 1;
        for (int i = 2; i <= first_num; i++) {
            if (first_num % i == 0 & second_num % i == 0){
                if(min1 == 1){
                    min1 = i;
                }else {
                    min2 = i;
                }

            }
        }
        System.out.println("min1: " + min1);
        System.out.println("min2: " + min2);

    }//end of main method

}// end of class