package q02;

import java.util.Arrays;

public class Main   {
    public static void main(String[] args) {

        Rational rational = new Rational();
        rational.simpleFraction(2,5);
        System.out.println(rational);

        System.out.println("------------------");

        Rational rational1 = new Rational();
        rational1.simpleFraction(1,5);
        System.out.println(rational1);

        System.out.println("-----------------------");

        Rational rational2 = rational.add(rational1);
        System.out.println(rational2);
        System.out.println(rational);

        System.out.println("-------------------------------");
        double rational3 = rational.toFloatingPoint(rational1);
        System.out.println(rational3);



        String rational4 = rational.mixedNumber(rational1);
        System.out.println(rational4);
    }
}
