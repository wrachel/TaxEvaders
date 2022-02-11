package com.project.passwordmanager.controllers.harry;

public class Animal {
    private String classification;
    private String species;
    private String name;
    public Animal(String c, String s, String n) {
        classification = c;
        species = s;
        name = n;
    }
    public String toString() {
        String str = "";
        str = name + " the " + species + " is a " + classification;
        return str;
    }
}
