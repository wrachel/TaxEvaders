package com.project.frqs.bryant;

import java.util.Arrays;

public class NumberSystem {

    /** Precondition: a and b are positive integers.
     * Returns the greatest common factor of a and b, as described in part (a). */
    public static int gcf(int a, int b) { // i hate doing recursion so i implemented the extended euclidean algorithm instead
        int[] bezouts = new int[] {1, 0, 0, 1}; // not technically necessary but i like math okay
        int q, temp, b1, b2, b3, b4, v1, v2;

        v1 = a; v2 = b; // sheerly for verification purposes

        while (b != 0) {
            q = a/b;
            temp = a % b; // java doesn't let us do parallel assignments i am so sad
            a = b;
            b = temp;

            b1 = bezouts[0]; b2 = bezouts[1]; b3 = bezouts[2]; b4 = bezouts[3]; // no parallel assignments part two electric boogaloo
            bezouts = new int[] {b2, b1 - q * b2, b4, b3 - q * b4};
        }

        if (bezouts[0] * v1 + bezouts[2] * v2 != a) { // something has gone terribly, terribly wrong.
            return -1;
        }
        return a;
    }

    /** Precondition: numerator and denominator are positive integers.
     * Reduces the fraction numerator / denominator
     * and prints the result, as described in part (b). */
    public static String reduceFraction(int numerator, int denominator) {
        int comFac = gcf(numerator, denominator);
        numerator /= comFac;
        denominator /= comFac;
        if (denominator == 1) {
            return String.valueOf(numerator);
        }
        return String.format("%d/%d", numerator, denominator);
    }

    public static void main(String[] args) {
        System.out.println(NumberSystem.gcf(7, 3));
        System.out.println(reduceFraction(7, 3));

        System.out.println(NumberSystem.gcf(30, 3));
        System.out.println(reduceFraction(30, 3));

        System.out.println(NumberSystem.gcf(24, 9));
        System.out.println(reduceFraction(24, 9));
    }
}