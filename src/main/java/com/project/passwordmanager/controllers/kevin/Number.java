package com.project.passwordmanager.controllers.kevin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Write a Class Number
public class Number {
    // instance variables

    private int squirrels;

    // Number has a zero Argument constructor
    // It initializes a random number between 3 and 36, ie the number of squirrels in class
    public Number() {
        // constructor
        squirrels = (int) (Math.random() * 34 + 3);
    }

    // It contains a getter for the Random Number
    public int getSquirrels() {
        return squirrels;
    }


    // It contains a getter for Index, or the order it was initialized
    public int getIndex(ArrayList<Number> list, Number object) {
        return list.indexOf(object);
    }


    // Write a tester method
    public static void main(String[] args) {
        // Create an ArrayList of Type Number, my ArrayList is called squirrels

        // Initialize 10 squirrels of class type Number
        Number test0 = new Number();
        Number test1 = new Number();
        Number test2 = new Number();
        Number test3 = new Number();
        Number test4 = new Number();
        Number test5 = new Number();
        Number test6 = new Number();
        Number test7 = new Number();
        Number test8 = new Number();
        Number test9 = new Number();

        Number[] list = {test0, test1, test2, test3, test4, test5, test6, test7, test8, test9};

        ArrayList<Number> squirrels = new ArrayList<>(Arrays.asList(list));
        ArrayList<Number> copy = new ArrayList<>(squirrels);

        // Insert Number instance into ArrayList Squirrel in least to greatest order by random number, mine required nested loops
        Number temp = new Number();

        for(int j = 0; j < squirrels.size() - 1; j++) {
            for (int i = 1; i <= 9; i++) {
                if (squirrels.get(i).getSquirrels() < squirrels.get(i - 1).getSquirrels()) {
                    temp = squirrels.get(i);
                    squirrels.set(i, squirrels.get(i-1));
                    squirrels.set(i - 1, temp);
                }
            }
        }


        // Print a formatted message with number of Squirrels and Index by which they were created, use enhanced for loop
        for(Number item : squirrels) {
            System.out.println("squirrels: " + item.getSquirrels() + " index: " + item.getIndex(copy, item));
        }
    }

}