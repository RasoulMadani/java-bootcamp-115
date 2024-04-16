import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter First Word :");
        String firstWord = input.nextLine().replace(" " ,"");
        System.out.println("Enter Second Word :");
        String secondWord = input.nextLine().replace(" ","");

        if (firstWord.length() != secondWord.length()){
            System.out.println("anagram nist");
            return;
        }

        for (int i = 0; i < firstWord.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < secondWord.length(); j++) {
                if (firstWord.charAt(i) == secondWord.charAt(j)){
                    flag=  false;
                }
            }
            if (flag ){
                System.out.println("in anagram nist");
                return;
            }
        }
        System.out.println("in anagram ast");
    }
}
