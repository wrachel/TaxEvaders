package com.project.frqs.bryant;

import java.util.Arrays;

public class Payroll {
    private int[] itemsSold; // number of items sold by each employee
    private double[] wages = new double[0]; // wages to be computed in part (b)

    public double computeBonusThreshold() {
        int[] minmax = findExtremes(itemsSold);
        int min = minmax[0];
        int max = minmax[1];
        int sum = 0;
        for (int items : itemsSold) {
            sum += items;
        }
        sum -= (min + max);
        return ((double) sum)/(itemsSold.length - 2);
    }

    public void computeWages(double fixedWage, double perItemWage) {
        double wage;
        double threshold = this.computeBonusThreshold();
        for (int i = 0; i < itemsSold.length; i++) {
            wage = (fixedWage + perItemWage * itemsSold[i]) * (itemsSold[i] > threshold ? 1.1 : 1.0);
            if (i + 1 > this.wages.length) {
                this.wages = Arrays.copyOf(this.wages, this.wages.length + 1);
            }
            this.wages[i] = wage;
        }
    }

    public double[] getWages() {
        return this.wages;
    }

    private int[] findExtremes(int[] array) {
        int min, max;
        min = array[0];
        max = array[0];
        for (int value : array) {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        return new int[] {min, max};
    }

    public Payroll(int[] itemsSold) {
        this.itemsSold = itemsSold;
    }

    public static void main(String[] args) {
        Payroll test = new Payroll(new int[] {48, 50, 37, 62, 38, 70, 55, 37, 64, 60});
        System.out.println(test.computeBonusThreshold());
        test.computeWages(10.0, 1.5);
        System.out.println(Arrays.toString(test.getWages()));
    }
}