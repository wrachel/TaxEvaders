package com.project.frqs.rachel;

public class RachelFRQ6Q2 {

        private int[] itemsSold = {48, 50, 37, 62, 38, 70, 55, 37, 64, 60}; // number of items sold by each employee

        private double[] wages; // wages to be computed in part (b)



        /** Returns the bonus threshold as described in part (a).

         */

        public double computeBonusThreshold()
        {
            int greatestSold = itemsSold[0];
            int leastSold = itemsSold[0];
            double total = 0;
            for(int i = 0; i < itemsSold.length; i++){
                if (itemsSold[i] > greatestSold){
                    greatestSold = itemsSold[i];
                }
                if (itemsSold[i] < leastSold){
                    leastSold = itemsSold[i];
                }

                total += itemsSold[i];
            }
            double average = (double) (total - greatestSold - leastSold) / (itemsSold.length - 2.0);
            System.out.println(average);
            return average;

            /* To be implemented in part (a) */

        }



        /** Computes employee wages as described in part (b)

         * and stores them in wages.

         * The parameter fixedWage represents the fixed amount each employee

         * is paid per day.

         * The parameter perItemWage represents the amount each employee

         * is paid per item sold.

         */

        public void computeWages(double fixedWage, double perItemWage)

        {
            double threshold = computeBonusThreshold();

            for (int i = 0; i < wages.length; i++){
                wages[i] += fixedWage + (perItemWage * itemsSold[i]);

                if (itemsSold[i] > threshold){
                    wages[i] = wages[i] * 1.1;
                }
                System.out.println("Wages of each worker: " + wages[i]);
            }

            /* To be implemented in part (b) */

        }


        // Other instance variables, constructors, and methods not shown.



}
