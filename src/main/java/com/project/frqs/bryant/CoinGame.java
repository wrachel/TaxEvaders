package com.project.frqs.bryant;

import java.util.Arrays;

public class CoinGame {
    private int startingCoins; // starting number of coins
    private int maxRounds; // maximum number of rounds played

    public CoinGame(int s, int r) {
        startingCoins = s;
        maxRounds = r;
    }

    /** Returns the number of coins (1, 2, or 3) that player 1 will spend. */
    public int getPlayer1Move() {
        return 1;
    }

    /** Returns the number of coins (1, 2, or 3) that player 2 will spend, as described in part (a). */
    public int getPlayer2Move(int round) {
        return (round % 3 == 0 ? 3 : (round % 2 == 0 ? 2 : 1));
    }

    /** Plays a simulated game between two players, as described in part (b). */
    public String playGame() {
        int p1Coins, p2Coins, p1Move, p2Move;
        p1Coins = p2Coins = startingCoins;
        int round = 1;

        while (round <= maxRounds && p1Coins > 2 && p2Coins > 2) {
            p1Move = getPlayer1Move();
            p2Move = getPlayer2Move(round);
            p1Coins -= p1Move;
            p2Coins -= p2Move;
            if (Math.abs(p1Move - p2Move) == 2) {
                p1Coins += 2;
            }
            else {
                p2Coins += 1;
            }
            round += 1;
        }
        return (p1Coins == p2Coins ? "tie game" : (p1Coins > p2Coins ? "player 1 wins" : "player 2 wins"));
    }

    public static void main(String[] args) {
        CoinGame game = new CoinGame(10, 5);
        System.out.println(game.playGame());
    }
}