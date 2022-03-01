package com.project.passwordmanager.controllers.kevin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Write a Class Number
public class Number {
    // instance variables

    private int squirrels;
    private static int count = 0;
    private int index;

    // Number has a zero Argument constructor
    // It initializes a random number between 3 and 36, ie the number of squirrels in class
    public Number() {
        // constructor
        squirrels = (int) (Math.random() * 34 + 3);
        index = Number.count++;
    }

    // It contains a getter for the Random Number
    public int getSquirrels() {
        return squirrels;
    }


    // It contains a getter for Index, or the order it was initialized
    public int getIndex() {
        return index;
    }


    // Write a tester method
    public static void main(String[] args) {
        // Create an ArrayList of Type Number, my ArrayList is called squirrels
        ArrayList<Number> squirrels = new ArrayList<>();
        // Initialize 10 squirrels of class type Number
        int SQUIRRELS = 10;
        for(int i = 0; i<SQUIRRELS; i++) {
            Number num = new Number();
            squirrels.add(num);
        }

        // Insert Number instance into ArrayList Squirrel in least to greatest order by random number, mine required nested loops
        Number temp;

        for(int j = 0; j < squirrels.size() - 1; j++) {
            for (int i = 1; i <= squirrels.size()-1; i++) {
                if (squirrels.get(i).getSquirrels() < squirrels.get(i - 1).getSquirrels()) {
                    temp = squirrels.get(i);
                    squirrels.set(i, squirrels.get(i-1));
                    squirrels.set(i - 1, temp);
                }
            }
        }


        // Print a formatted message with number of Squirrels and Index by which they were created, use enhanced for loop
        for(Number item : squirrels) {
            System.out.println("squirrels: " + item.getSquirrels() + " index: " + item.getIndex());
        }
    }

}