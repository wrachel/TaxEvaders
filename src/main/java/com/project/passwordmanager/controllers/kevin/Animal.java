package com.project.passwordmanager.controllers.kevin;

public class Animal {
    private String diet;
    private String species;
    private String name;

    public Animal(String d, String s, String n) {
        diet = d;
        species = s;
        name = n;
    }

    @Override
    public String toString() {
        return name + " the " + species + " is a " + diet;
    }

    public static void main(String[] args) {
        Animal turtle = new Animal("herbivore", "turtle", "Timmy");
        System.out.println(turtle.toString());
    }
}
