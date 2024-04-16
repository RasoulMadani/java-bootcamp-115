package hw01;

import java.util.Arrays;
import java.util.Scanner;

public class Quesion01 {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter Your String :");
//        String str = input.nextLine();
//        String[] strArray = new String[(int)Math.pow(2,str.length())];
//        System.out.println(Arrays.toString(strArray);
////        System.out.println((int)Math.pow(2,2));
//        for (int i = 0; i < str.length(); i++) {
//            System.out.println(str.charAt(i));
//            // A
//            for (int j = i+1; j < str.length(); j++) {
//                // B C
//                strArray[i] =
//            }
//        }
//
//    }

    public static void main(String[] args)
    {
        String str = "ABC";
        int n = str.length();
        Quesion01 permutation = new Quesion01();
        permutation.permute(str, 0, n-1);
    }

    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
