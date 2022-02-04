package com.project.passwordmanager.controllers.kevin;

public class NumberSystem {

    public static void main(String[] args) {
        System.out.println(gcf(7,3));
        reduceFraction(8, 20);
    }

    public static int gcf(int a, int b) {
        if(a%b == 0) {
            return b;
        }
        return gcf(b, a%b);
    }

    //used to be void
    public static String reduceFraction(int numerator, int denominator) {
        int answer;
        if(numerator%denominator == 0) {
            System.out.println(numerator/denominator);

            answer = numerator/denominator;
            return Integer.toString(answer);
        } else {
            int gcf = gcf(numerator, denominator);
            int newNumerator = numerator/gcf;
            int newDenominator = denominator/gcf;
            System.out.println(newNumerator + "/" + newDenominator);

            return newNumerator + "/" + newDenominator;
        }
    }

}
