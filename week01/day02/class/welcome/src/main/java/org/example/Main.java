package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        boolean flag = true;
        while(flag){
            int digit = number.length();
            int sum = 0;
            for (int i = 0; i<number.length();i++){
                sum+= Integer.parseInt(String.valueOf(number.charAt(i)));
            }
            if (String.valueOf(sum).length()==1){
                System.out.println(sum);
                flag = false;
            }
            else {
                number = String.valueOf(sum);
            }
        }

    }
}