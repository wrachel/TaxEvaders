package com.project.passwordmanager.controllers.harry;

public class NumberSystem {
    /** Precondition: a and b are positive integers.

     * Returns the greatest common factor of a and b, as described in part (a).

     */

    public static int gcf(int a, int b)

    {  if (b==0)
        return a;
    else
        return gcf(b, a % b);
    }



    /** Precondition: numerator and denominator are positive integers.

     * Reduces the fraction numerator / denominator

     * and prints the result, as described in part (b).

     */

    public static String reduceFraction(int n, int d)



    {

        int newn= n/gcf(n,d);
        int newd= d/gcf(n,d);

        if(newd!=1) {
            return newn + "/" + newd;
        }
        else if(newd==0){
            return "undefined";
        }
        else{
            return Integer.toString(newn);
        }

    }
    public static void main(String[] args){
        System.out.println(gcf(64, 124));
        System.out.println(reduceFraction(45,60));
    }

}
