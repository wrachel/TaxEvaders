package com.project.passwordmanager.controllers.kevin;

public class Elephant extends Herbivore{
    private double tuskLength;

    public Elephant(String n, double tusks) {
        super("elephant", n);
        tuskLength = tusks;
    }

    @Override
    public String toString() {
        return super.toString() + " with tusks " + tuskLength + " meters long";
    }

    public static void main(String[] args) {
        Elephant percy = new Elephant("Percy", 2.0);
        System.out.println(percy.toString());
    }
}
