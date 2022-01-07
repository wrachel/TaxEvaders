package com.project.frqs.rachel;
import java.util.Random;
import java.lang.Math;

public class rachel_frq4_game {
    private int startingCoins; //starting number of coins
    private int maxRounds; // max number of rounds played

    public rachel_frq4_game(int s, int r)
    {
        startingCoins = s;
        maxRounds = r;
    }

    //returns player1move as 1
    public int getPlayer1Move(){
        return 1;
    }

    //getting player 2's move
    public int getPlayer2Move(int round){
        int result;
        if (round % 3 == 0){
            result = 3;
        }
        else if (round % 2 == 0 && round %3 != 0){
            result = 2;
        }
        else{
            result = 1;
        }
        return result;
    }
    public String playGame(){
        int player2coins = startingCoins;
        int player1coins = startingCoins;

        for(int round=1; round <= maxRounds && player2coins > 2 && player1coins > 2; round++){

            int p1Spends = getPlayer1Move();
            int p2Spends = getPlayer2Move(round);

            player2coins -= p2Spends;
            player1coins -= p1Spends;
            int diff = Math.abs(p1Spends-p2Spends);
            if (diff == 0){
                player2coins += 1;
                continue;
            }
            else if (diff == 1){
                player2coins += 1;
                continue;
            }
            else{
                player1coins += 2;
                continue;
            }
        }
        String winner = "";
        if (player1coins == player2coins){
            winner = "tie game";
        }
        else if (player1coins > player2coins){
            winner = "player 1 wins";
        }
        else{
            winner = "player 2 wins";
        }

        return winner;
    }
}
