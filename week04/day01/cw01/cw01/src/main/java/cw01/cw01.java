package cw01;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class cw01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("what you want to learning ? + * / - ");
        String subject = input.nextLine();
        System.out.println("subject : " + subject);

        System.out.println("Enter your Level For learning: 1 digits ? or 2 digits ? or 3 digits ?");

        int level = input.nextInt();
        System.out.println("subject : " + subject + " " + " level :" + level);

        System.out.println("how many Question you want to answer ? ");
        int countQuestions = input.nextInt();

        System.out.println("subject : " + subject + " " + " level :" + level + " count of Questions :" + countQuestions);

        generateQuestions(countQuestions,level,subject,input);


    }
    public static int generateRandomDigits(int level){
        int randomNum = 1;
        int min = 1;
        int max = 9;
        if (level == 2) {
            min = 10;
            max = 99;
        } else if (level == 3) {
            min = 100;
            max = 999;
        }
        return randomNum = (int)(Math.random() * (max - min + 1)) + min;
    }

    public static int calculator(int number1 , int number2 ,String subject){
        int result = 0;
        if (Objects.equals(subject, "*")){
            result = number1 * number2;
        } else if (Objects.equals(subject, "/")) {
            result = number1 / number2;
        } else if (Objects.equals(subject, "-")) {
            result = number1 - number2;
        } else if (Objects.equals(subject, "+")) {
            result = number1 + number2;
        }
        return  result;
    }

    public static void generateQuestions(int countQuestions,int level,String subject,Scanner input){
        int correct = 0;
        int totalQuestions = countQuestions;
        String[] scores = new String[totalQuestions];
        int counter = 0;
        while (countQuestions > 0){
            int number1 = generateRandomDigits(level);
            int number2 = generateRandomDigits(level);
            int result = calculator(number1,number2,subject);
            System.out.println(number1 + " " + subject + " " + number2 + " = ?" + " enter your answer:");
            int answer = input.nextInt();
            System.out.println(answer + " " + result);
            if (answer != result){
                scores[counter] = "false";
                System.out.println("Wrong . your answer not correct!!!!!");
            }else {
                scores[counter] = "true";
                correct++;
                System.out.println("Great your answer is Correct ");
            }
            System.out.println(Arrays.toString(scores));
            countQuestions--;
            counter++;
        }
        double percentage = ((double) correct / totalQuestions) * 100;
        System.out.println("\n" + percentage + " % " + " your  score \n");
        generateTableResults(totalQuestions,scores);
    }

    public  static  void generateTableResults (int totalQuestions,String[] scores){
        System.out.println("table of Scores : ");
        for (int i = 0 ; i < totalQuestions; i++) {
            System.out.println((i+1) + " | " + scores[i]);
            System.out.println("-----------");
        }
    }

}
