package com.project.passwordmanager.controllers.harry;

import java.util.concurrent.ThreadLocalRandom;

public class frq4 {

    private int playerOneCoins;
    private int playerTwoCoins;
private char previousChar;
private String largestStreak, currentStreak;

//question a
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


    //question b
    public int getPlayer1Move(){
        int max = 3;
        int min = 1;
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        return tlr.nextInt(min, max+1);
    }

    public int getPlayer2Move(int round) {
        if(round %3==0) {
            return 3;
        }
        if(round %2==0) {
            return 2;
        }
        return 1;
    }

    public String playGame(int r, int c, int t){
         playerOneCoins = c;
         playerTwoCoins = t;
        int numberOfRoundsLeft = r;

        //game simulation loop
        while(playerOneCoins > 3 && playerTwoCoins > 3 && numberOfRoundsLeft >0){
            numberOfRoundsLeft --;
            int m1 =getPlayer1Move();
            int m2 = getPlayer2Move(numberOfRoundsLeft);
            playerOneCoins -=m1;
            playerTwoCoins -=m2;
            if(m1==m2){
                playerTwoCoins +=1;

            }
            if(m1-m2==1){
                playerTwoCoins +=1;
            }
            if(m1-m2==2){
                playerOneCoins +=1;
            }
        }
        if(playerOneCoins > playerTwoCoins){
            return "Player 1 wins!";
        }
        if(playerTwoCoins > playerOneCoins){
            return "Player 2 wins!";
        }

            return "Tie game!";

    }

    public int firstcoin(){
        return playerOneCoins;
    }
    public int secondcoin(){
        return playerTwoCoins;
    }
}
