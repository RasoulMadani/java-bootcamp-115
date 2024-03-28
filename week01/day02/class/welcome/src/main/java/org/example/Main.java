package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int counter = 1;
        int bakhsh = 0;
         while (bakhsh <31){
             counter++;
             if(counter/4 == 0){
                 bakhsh++;
                 System.out.println(counter);
             }
         }
    }
}