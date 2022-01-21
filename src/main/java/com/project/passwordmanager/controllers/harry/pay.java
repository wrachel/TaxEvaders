package com.project.passwordmanager.controllers.harry;


public class pay {
    private int[] itemsSold; // number of items sold by each employee

    private double[] wages= new double[10]; // wages to be computed in part (b)

    public double computeBonusThreshold(int[] number) {
        itemsSold = number;

        int total = itemsSold[0];
        int min = itemsSold[0];
        int max = itemsSold[0];
        for(int i = 1; i < itemsSold.length; i++) {
            total += itemsSold[i];
            if(itemsSold[i] < min) {
                min = itemsSold[i];
            }
            if(itemsSold[i] > max) {
                max = itemsSold[i];
            }
        }
        return (total - min - max) / (double) (itemsSold.length - 2);
    }
    public double[] computeWages(double fixedWage, double perItemWage, double threshold) {
        //double threshold = computeBonusThreshold();
        for(int i = 0; i < itemsSold.length; i++) {
            double baseWage = fixedWage + perItemWage * itemsSold[i];
            if(itemsSold[i] > threshold) {
                wages[i] = baseWage * 1.1;
            }
            else {
                wages[i] = baseWage;
            }
        }
        return wages;
    }


}
