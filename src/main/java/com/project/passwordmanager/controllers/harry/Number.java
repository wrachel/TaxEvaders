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
      this.squirrelnum=  (int)(Math.random()*33)+3;

    }

    // It contains a getter for the Random Number
    public  int getnum(){
        return squirrelnum;
    }

    // It contains a getter for Index, or the order it was initialized


    // Write a tester method
    public static void main(String[] args) {

        // Create an ArrayList of Type Number, my ArrayList is called squirrels
        ArrayList<Integer> squirrels = new ArrayList<Integer>();
        // Initialize 10 squirrels of class type Number

        for(int i =1; i<11;i++) {
            Number obj = new Number();
            squirrels.add(obj.getnum());
        }
        System.out.println(squirrels);
        // Insert Number instance into ArrayList Squirrel in least to greatest order by random number, mine required nested loops

        for(int i = 1; i<10; i++){
            int num=squirrels.get(i);
            int num2 =squirrels.get(i++);
            if(num>num2){
            }
        }

        // Print a formatted message with number of Squirrels and Index by which they were created, use enhanced for loop

    }

}