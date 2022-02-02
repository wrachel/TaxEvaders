package com.project.passwordmanager.controllers.kevin;

import java.util.ArrayList;

public class UserName

{

// The list of possible usernames, based on a user’s first and last names and initialized by the constructor.

    ArrayList<String> possibleNames;


    /** Constructs a UserName object as described in part (a).

     * Precondition: firstName and lastName have length greater than 0

     * and contain only uppercase and lowercase letters.

     */
    public UserName(){}
    public UserName(String firstName, String lastName)

    {
        possibleNames = new ArrayList<>();
        for(int i = 1; i<=firstName.length(); i++) {
            possibleNames.add(lastName+firstName.substring(0,i));
        }

    }

    /** Returns true if arr contains name, and false otherwise. */

    public boolean isUsed(String name, String[] arr)

    {
        for(String names : arr) {
            if(name.equals(names)) {
                return true;
            }
        }

        return false;
    }


    public void setAvailableUserNames(String[] usedNames)
    {
    ArrayList<String> temp = new ArrayList<>();
        for (String possibleName : possibleNames) {
            if (!(isUsed(possibleName, usedNames))) {
                temp.add(possibleName);
            }
        }
        possibleNames.clear();
        possibleNames.addAll(temp);
    }

    // for testing purposes
    public static void main(String[] args) {
        UserName user1 = new UserName("Kevin", "Do");
        String[] used = {"DoKev", "DoKevin"};
        user1.setAvailableUserNames(used);
        for(String name: user1.possibleNames){
            System.out.println(name);
        }
    }

}