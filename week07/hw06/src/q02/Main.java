package q02;

import java.util.Arrays;

public class Main   {
    public static void main(String[] args) {

        Rational rational = new Rational();
        rational.simpleFraction(2,5);
        System.out.println(rational);

        Rational rational1 = new Rational();
        rational1.simpleFraction(1,5);
        System.out.println(rational1);

        Rational rational2 = rational.sub(rational1);
        System.out.println(rational2);
    }
}
