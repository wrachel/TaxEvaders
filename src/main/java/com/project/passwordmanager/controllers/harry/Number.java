package com.project.passwordmanager.controllers.harry;



import java.util.ArrayList;


// Write a Class Number
public class Number {
    // instance variables

    // Number has a zero Argument constructor

    // It initializes a random number between 3 and 36, ie the number of squirrels in class
    private int squirrelnum;

    public Number() {
        // constructor
        this.squirrelnum = (int) (Math.random() * 33) + 3;

    }

    // It contains a getter for the Random Number
    public int getnum() {
        return squirrelnum;
    }

    // It contains a getter for Index, or the order it was initialized
    public int index(int i){

        return i;

    }

    // Write a tester method
    public static void main(String[] args) {

        // Create an ArrayList of Type Number, my ArrayList is called squirrels
        ArrayList<Integer> squirrels = new ArrayList<Integer>();

        ArrayList<Integer> numindex= new ArrayList<Integer>();

        // Initialize 10 squirrels of class type Number

        for (int i = 0; i < 11; i++) {
            Number obj = new Number();
            squirrels.add(obj.getnum());
            numindex.add(obj.index(i));
        }


        for(int i=0; i<squirrels.size()-1; i++) {
            if (squirrels.get(i)>squirrels.get(i+1)) {
                int temp =squirrels.get(i);
                squirrels.set(i,squirrels.get(i+1));
                squirrels.set(i+1, temp);

                int temp2=numindex.get(i);
                numindex.set(i, numindex.get(i+1));
                numindex.set(i+1, temp2);

                i=-1;

            }
        }
        // Print a formatted message with number of Squirrels and Index by which they were created, use enhanced for loop
        for(int i=0; i<squirrels.size()-1; i++) {
            System.out.println("squirrel: "+squirrels.get(i)+ " Day: "+numindex.get(i));
        }
    }
}

