package com.project.frqs.rachel.frq9;

public class rachelAnimal {

    private String type;
    private String species;
    private String name;

    public rachelAnimal(String t, String s, String n){
        type = t;
        species = s;
        name = n;
    }

    public String toString(){
        String returnStatement = name + " the " + species + " is a " + type + " ";
        return returnStatement;
    }
}
