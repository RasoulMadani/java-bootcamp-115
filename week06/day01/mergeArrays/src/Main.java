
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array1 = new int[3];
        int[] array2 = new int[3];

        int[] array3 = new int[6];
//        0,1,2,3,..99 ,100,199
        int number = sc.nextInt();
        int counter;
        for (int i = 0; i < number; i++) {
            array1[i] = sc.nextInt();
//            System.out.println("array number in the array 1 : " + array1[i]);
        }
        System.out.println(Arrays.toString(array1));
        for (int i = 0; i < number; i++) {
            array2[i] = sc.nextInt();
//            System.out.println("array number in the array2 : " + array2[i]);
        }
        System.out.println(Arrays.toString(array2));
        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }
        System.out.println(Arrays.toString(array3));

        for (int i = array2.length, k = 0; i < array3.length; i++, k++) {
            array3[i] = array2[k];
        }
        System.out.println(Arrays.toString(array3));
        for (int i = 0; i < array3.length; i++) {
            for (int j = 0; j < array3.length; j++) {
                if (array3[i] <= array3[j]) {
                    int temp = array3[j];
                    array3[j ] = array3[i];
                    array3[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array3));

    }
}

