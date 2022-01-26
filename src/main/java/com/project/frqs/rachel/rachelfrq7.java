package com.project.frqs.rachel;

import java.util.ArrayList;
import java.lang.Math;
import java.io.*;

public class rachelfrq7 {
    // The list of possible user names, based on a user’s first and last names and initialized by the constructor.

    private ArrayList<String> possibleNames = new ArrayList<String>();

    //part a
    public rachelfrq7(String firstName, String lastName){
        if (firstName.length() > 0 && lastName.length() > 0 && firstName.matches("[a-zA-Z]+") && lastName.matches("[a-zA-Z]+")){
            for(int i = 0; i < firstName.length(); i++){
                String newUsername = lastName + firstName.substring(0, i);
                possibleNames.add(newUsername);
            }
        }
        else{
            System.out.println("Please make sure both firstName and lastName only contain upper/lowercase letters, and are at least a length of 1");
        }
    }

    /** Returns true if arr contains name, and false otherwise.
     public boolean isUsed(String name, String[] arr){

     }

     //part b
     public void setAvailableUserNames(String[] usedNames) {
     for(int i = 0; i < possibleNames.size(); i++){
     if (isUsed(possibleNames.get(i), usedNames)){
     possibleNames.remove(i);
     i--;
     }
     }
     }
     */


    public String randomUsername() {
        int index = (int)(Math.random() * possibleNames.size());
        String userName = possibleNames.get(index);
        return userName;
    }

}
