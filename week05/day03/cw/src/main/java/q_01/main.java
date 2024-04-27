import java.util.Random;
import java.util.Scanner;

public class main3 {
    static Scanner scanner = new Scanner(System.in);
    static int number;
    static Random random = new Random();

    public static void main(String[] args) {
        boolean flag = false;
        boolean wrong = true;
        int total = 1;
        number = random.nextInt(100, 1000);
        while (!flag) {
            String numberStr = String.valueOf(number);
            int count = 0;
            String input = scanner.nextLine();
            if (input.equals(numberStr)) {
                System.out.println("you got it !!");
                flag = check(false);
                continue;
            }
            wrong = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (input.charAt(i) == numberStr.charAt(j)) {
                        wrong = false;
                        if (i == j) {
                            System.out.println("fermi");

                            break;
                        } else {
                            System.out.println("pico");
                        }
                    }
                }
            }
            if (wrong) {
                System.out.println("Bagels");
            }
            total++;
            if (total > 10) {
                flag = check(true);
            }
        }
    }

    public static boolean check(boolean gameover) {
        if (gameover) {
            System.out.println("game over !");
        } else {
            System.out.println(" you win!! ");
        }
        System.out.println("do you want to continue 'y' or 'n' ");
        String string = scanner.nextLine().toLowerCase();
        if (string.equals("y")) {
            number = random.nextInt(100, 1000);
            return false;
        }
        return true;
    }
}