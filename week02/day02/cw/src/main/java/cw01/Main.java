package cw01;

import java.util.Arrays;



public class Main {
    public static void main(String[] args) {
        int[] array1 = new int[]{10,2,3,4,5,6,2,2,2,2,2};

        int[] array2 = new int[array1.length];
        array1[0] = 3;
        System.out.println(Arrays.toString(array1));

        for (int i = 0; i < array1.length; i++) {
            array2[i] = array1[i];
        }
        System.out.println(Arrays.toString(array2));
    }
}