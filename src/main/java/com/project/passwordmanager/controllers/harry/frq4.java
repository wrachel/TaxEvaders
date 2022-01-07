package com.project.passwordmanager.controllers.harry;

public class frq4 {

private char previousChar;
private String largestStreak, currentStreak;

    public String longestStreak(String str) throws IndexOutOfBoundsException{
        previousChar = ' ';

         largestStreak = "";
         currentStreak = "";

         for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) != previousChar){
                currentStreak = "";
            }
            currentStreak += str.charAt(i);
            if (currentStreak.length() > largestStreak.length()){
                largestStreak = currentStreak;
            }
            previousChar = str.charAt(i);
        }
        return largestStreak.charAt(0)+" "+" "+"length: "+largestStreak.length();
    }

}
