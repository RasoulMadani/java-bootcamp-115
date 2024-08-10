import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        System.out.println("Enter millis :");
        Scanner scanner = new Scanner(System.in);
        int millis = scanner.nextInt();
        while(count++ < 20){
            System.out.println(LocalTime.now());
            Thread.sleep(millis);
        }
    }
}
