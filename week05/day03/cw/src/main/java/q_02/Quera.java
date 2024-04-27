package q_02;

import java.util.Scanner;

public class Quera {

    //        ########.......########
//            #ghorfe1.......ghorfe2#
//            ########.......########
//            #ghorfe3..............#
//            ########.......########
//            #.....................#
//            ########.......########
//            #.....................#
//            #######################
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your Ghorfeh : ");
        int counter = input.nextInt();
        int j = 1;
        for (int i = 0; i < 4; i++) {
            System.out.println();
            System.out.println("########.......########");
            if (j <= counter) {
                System.out.print("#ghorfe" + j);
                System.out.print(".......");
                j++;
            } else {
                System.out.print("#.......");
                System.out.print(".......");
            }
            if (j <= counter) {
                System.out.print("ghorfe" + j + "#");
                j++;
            } else {
                System.out.print(".......#");
            }
        }
        System.out.println("\n#######################");
    }
}