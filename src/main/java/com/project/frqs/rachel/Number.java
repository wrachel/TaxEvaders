package com.project.frqs.rachel;

import java.lang.Math;
import java.util.ArrayList;

public class Number {
    private static int randomNum;
    private static int index;

    public Number(){
        randomNum = (int)(Math.random() * 33 ) + 3;
    }

    public int getRandomNum(){
        return randomNum;
    }

    public int getIndex(){
        return index;
    }

    public static void main(String[] args){
        ArrayList<Integer> squirrels = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Number init = new Number();
            squirrels.add(init.getRandomNum());
        }
        for(int myValue: squirrels){
            System.out.println("Squirrels: " + myValue + " Day: " + squirrels.indexOf(myValue));
        }
    }


}
