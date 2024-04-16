package hw03;

import java.util.Arrays;
import java.util.Scanner;

public class Question03 {
    public static void main(String[] args) {
//       int[][] array = getArrayElement();
//       int sizeOfArray = array[1][0];

//       int [] array1 = array[0];
//        int [] array1 = new int[]{3,0,2,0,4};
        int [] array1 = new int[]{1,2,0,3,1,0,1,2,2,1,2,0,1};
        int sizeOfArray = array1.length;
//       int maxIntInArray = getMaxIntInArray(array[0],array[1][0]);
        int maxIntInArray = 3;

//       System.out.println(maxIntInArray);
       int countOfWaterBox = 0;
        System.out.println(Arrays.toString(array1));
        for (int i = 0; i < maxIntInArray; i++) {
            for (int j = 1; j < sizeOfArray; j++) {
               if( j+1 < sizeOfArray && array1[j] < array1[j+1] && array1[j] < array1[j-1]){
                   System.out.println(j + " " +array1[j+1] + "j+1");
                    countOfWaterBox++;
                    array1[j]++;
               }
            }
            System.out.println(countOfWaterBox );
            System.out.println(Arrays.toString(array1));
        }



    }
    public static int[][] getArrayElement(){
        Scanner input = new Scanner(System.in);
        System.out.println("enter Size of numbers :");
        int sizeArray = input.nextInt();

        int[] array = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            System.out.println("Enter next int :");
            array[i] = input.nextInt();
        }
        int[][] matrix = {
                array,
                {sizeArray}
        };
        return matrix;
    }
    public static int getMaxIntInArray(int[] array,int sizeArray){
        int maxInt = array[0];
        for (int i = 0; i < sizeArray; i++) {
            if (i+1 < sizeArray && array[i] < array[i+1]){
                maxInt = array[i+1];
            }
        }
        return maxInt;
    }
}
