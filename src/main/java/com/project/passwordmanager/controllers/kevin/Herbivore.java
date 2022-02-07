package com.project.passwordmanager.controllers.kevin;

public class Herbivore extends Animal{

    public Herbivore(String s, String n) {
        super("herbivore", s, n);
    }

    public static void main(String[] args) {
        Herbivore veganTeacher = new Herbivore("human", "vegan teacher");
        System.out.println(veganTeacher.toString());
    }
}
