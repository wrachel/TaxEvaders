package com.project.passwordmanager.controllers.kevin;

public class Payroll

{

    private int[] itemsSold;

    private double[] wages;

    public double computeBonusThreshold()
    {
        /* To be implemented in part (a) */
        int least = itemsSold[0];
        int most = itemsSold[0];
        double avg = 0;

        for (int i = 0; i<itemsSold.length; i++) {
            avg += itemsSold[i];
            if (itemsSold[i]>most) {
                most = itemsSold[i];
            }
            if (itemsSold[i]<least) {
                least = itemsSold[i];
            }
        }
        avg -= (most + least);
        avg /= 8;
        return Math.round(avg);
    }

    public void computeWages(double fixedWage, double perItemWage)
    {
        for(int i = 0; i<itemsSold.length; i++) {
            wages[i] = 10.0 + 1.5 * itemsSold[i];
            if (itemsSold[i] > computeBonusThreshold()) {
                wages[i] *= 1.1;
            }
        }
    }



// Other instance variables, constructors, and methods not shown.

    public static void main(String[] args) {
        int[] arr = {48, 50, 37, 62, 38, 70, 55, 37, 64, 60};
        double[] arr2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Payroll test = new Payroll(arr, arr2);
        test.computeWages(10.0, 1.5);
        System.out.println(test.wages[0]);
        System.out.println(test.wages[9]);
    }

    public double[] getWages() {
        return wages;
    }

    public int[] getItemsSold() {
        return itemsSold;
}

    public Payroll(int[] itemsSold, double[] wages) {
        this.itemsSold = itemsSold;
        this.wages = wages;
    }

    public Payroll() {}
}