package com.project.frqs.rachel;

public class rachelfrq10 {

    /** Precondition: a and b are positive integers.

     * Returns the greatest common factor of a and b, as described in part (a).

     */
// when done recursively -> althought, it doesn't work??
    public static int gcf(int a, int b){

        int temp = a % b;
		if(temp == 0){
			return b;
		}
		else{
			return gcf(b, temp);
		}
    }



    /** Precondition: numerator and denominator are positive integers.

     * Reduces the fraction numerator / denominator

     * and prints the result, as described in part (b).

     */

    public static String reduceFraction(int numerator, int denominator){
        String returnValue = "";
        if(numerator % denominator == 0){
            Integer i = numerator / denominator;
            returnValue = i.toString();
            System.out.println(returnValue);
        }
        else{
            rachelfrq10 temp = new rachelfrq10();
            int gcf = temp.gcf(numerator, denominator);
            int num = numerator/gcf;
            int den = denominator/gcf;
            returnValue = num + "/" + den;
            System.out.println(returnValue);
        }

        return returnValue;

    }

    /* TEster method
    public static void main(String[] args){
        int a = 36;
        int b = 8;
        rachelfrq10 test = new rachelfrq10();
        System.out.println(test.gcf(a, b));
        test.reduceFraction(30, 10);
    }

     */




}
