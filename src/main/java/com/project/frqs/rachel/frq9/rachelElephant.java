package com.project.frqs.rachel.frq9;

public class rachelElephant extends rachelHerbivore{
    private double tusks;

    public rachelElephant(String n, double tu){
        super("elephant", n);
        tusks = tu;
    }

    public String toString(){
        String s = super.toString() + "with tusks " + tusks + " meters long";
        return s;
    }
/* tester method
    public static void main(String[] args){
        rachelElephant percy = new rachelElephant("Percy", 2.0);
        System.out.println(percy.toString());
    }

 */

}
