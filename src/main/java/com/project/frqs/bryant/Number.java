package com.project.frqs.bryant;

import java.util.ArrayList;
import java.util.Random;

// Write a Class Number
public class Number {
    // instance variables
    private int classSize, index;
    static int count;

    // Number has a zero Argument constructor
    // It initializes a random number between 3 and 36, ie the number of squirrels in class
    public Number() {
        Random randGen = new Random();
        this.classSize = randGen.nextInt(33) + 3;
        this.index = count;

        count++;
    }

    // It contains a getter for the Random Number
    public int getClassSize() {
        return this.classSize;
    }

    // It contains a getter for Index, or the order it was initialized
    public int getIndex() {
        return this.index;
    }

    // Write a tester method
    public static void main(String[] args) {
        // Create an ArrayList of Type Number, my ArrayList is called squirrels
        ArrayList<Number> squirrels = new ArrayList<Number>();

        // Initialize 10 squirrels of class type Number
        for (int i = 0; i < 10; i++) {
            squirrels.add(new Number());
        }

        // Insert Number instance into ArrayList Squirrel in least to greatest order by random number, mine required nested loops
        for (int i = 1; i < squirrels.size(); i++) {
            Number squirrel = squirrels.get(i);

            int searchIdx = i;
            while (squirrel.getClassSize() < squirrels.get(searchIdx).getClassSize()) {
                searchIdx--;
            }

            if (searchIdx != i) {
                squirrels.add(searchIdx, squirrel);
                squirrels.remove(i + 1);
            }
        }

        // Print a formatted message with number of Squirrels and Index by which they were created, use enhanced for loop
        for (Number squirrel : squirrels) {
            System.out.println(String.format("Squirrels: %d Day: %d", squirrel.getClassSize(), squirrel.getIndex()));
        }

    }

}