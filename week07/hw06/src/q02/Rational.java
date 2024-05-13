package q02;

import q02.CommonClasses.FindBigDivisor;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class Rational {
    private int numerator = 0;
    private int denominator = 1;

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void simpleFraction(int x, int y) {
        int bigDivisor = FindBigDivisor.find(x, y);
        numerator = x / bigDivisor;
        denominator = y / bigDivisor;
    }

    public Rational add(Rational num) {
        Rational rational = new Rational();

        int numerators1 = numerator * num.getDenominator();
        int denominators = denominator * num.getDenominator();
        int numerators3 = num.getNumerator() * denominator;
        rational.simpleFraction(numerators1+ numerators3, denominators);
        return rational;
    }

    public Rational sub(Rational num) {
        Rational rational = new Rational();

        int numerators = abs((numerator * num.getDenominator()) - (num.getNumerator() * denominator));
        int denominators = denominator * num.getDenominator();
        rational.simpleFraction(numerators, denominators);
        return rational;
    }

    public Rational mul(Rational num) {
        Rational rational = new Rational();

        int numerators = numerator * num.getNumerator();
        int denominators = denominator * num.getDenominator();
        rational.simpleFraction(numerators, denominators);
        return rational;
    }

    public Rational div(Rational num) {
        Rational rational = new Rational();

        int numerators = numerator * num.getDenominator();
        int denominators = denominator * num.getNumerator();
        rational.simpleFraction(numerators, denominators);
        return rational;
    }

    public double toFloatingPoint(Rational num) {

        return (double) num.getNumerator() / num.getDenominator();
    }

    public String mixedNumber(Rational num) {
        int div = num.getNumerator() / num.getDenominator();
        int reminder = num.getNumerator() % num.getDenominator();
        return  reminder+ "/" + num.getDenominator() + "+" + div;
    }

    public String toString1() {
        return "Rational{" +
                +numerator +
                ", /" + denominator +
                '}';
    }

    @Override
    public String toString() {
        return "Rational{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
