package com.project.frqs.rachel;

import java.lang.Math;
import java.util.ArrayList;

public class Number {
    private static int randomNum;
    private static int index;
    private static int COUNT = 0;

    public Number(){
        this.randomNum = (int)(Math.random() * 34 ) + 3;
        this.index = Number.COUNT++;
    }

    public int getRandomNum(){
        return this.randomNum;
    }

    public int getIndex(){
        return this.index;
    }

    public String toString(){return "Squirrels: " + this.getRandomNum() + " Day: " + this.getIndex();}

    public static void main(String[] args){
        ArrayList<Number> squirrels = new ArrayList<Number>();

        int squirrelNum = 10;
        /*
        for(int i = 0; i < squirrelNum; i++){
            Number init = new Number();

            for(int j = 0; true; j++){
                //conditions
                if ((squirrels.size() == j) || (init.getRandomNum() < squirrels.get(j).getRandomNum())){
                    squirrels.add(j, init);

                    break;
                }
            }
        }

         */
        for(int i = 0; i < squirrelNum; i++){
            Number num = new Number();
            squirrels.add(i, num);
        }



        for(Number myValue: squirrels){
            System.out.println(myValue);
        }
    }


    /*
    public static void main(String[] args){
        ArrayList<Number> squirrels = new ArrayList<Number>();

        for (int i = 0; i < 10; i++){
            Number number = new Number();
            numbers[i] = number.getRandomNum();

            squirrels.add(new Number());
        }
        for(Number myValue: squirrels){

            System.out.println("Squirrels: " + myValue + " Day: " + squirrels.indexOf(myValue));
        }

    }

     */

}
