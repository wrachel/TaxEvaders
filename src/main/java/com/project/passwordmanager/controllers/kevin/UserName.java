package com.project.passwordmanager.controllers.kevin;

import java.util.ArrayList;

public class UserName

{

// The list of possible user names, based on a user’s first and last names and initialized by the constructor.

    private ArrayList<String> possibleNames;
    private ArrayList<String> usedNames;
    private String firstName;
    private String lastName;


    /** Constructs a UserName object as described in part (a).

     * Precondition: firstName and lastName have length greater than 0

     * and contain only uppercase and lowercase letters.

     */

    public UserName(String firstName, String lastName)

    {
        this.firstName = firstName;
        this.lastName = lastName;
        possibleNames = new ArrayList<String>();

        for(int i = 1; i<=firstName.length(); i++) {
            possibleNames.add(lastName+firstName.substring(0,i));
        }

    }

    /** Returns true if arr contains name, and false otherwise. */

    public boolean isUsed(String name, String[] arr)

    {
        for(String names : arr) {
            return name.equals(names);
        }

        return false; // idk it made me put a return statement
    }


    public void setAvailableUserNames(String[] usedNames)
    {
        for(int i = 0; i < possibleNames.size(); i++) {
            if(isUsed(possibleNames.get(i), usedNames)) {
                possibleNames.remove(i);
            }
        }
    }

    // for testing purposes
    public static void main(String[] args) {
        UserName user1 = new UserName("Kevin", "Do");
        String[] used = {"DoKev"};
        user1.setAvailableUserNames(used);
        for(String name: user1.possibleNames){
            System.out.println(name);
        }
    }

}