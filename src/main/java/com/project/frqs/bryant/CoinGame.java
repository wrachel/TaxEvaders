package com.project.frqs.bryant;

import java.util.Arrays;
import java.util.Random;

public class CoinGame {
    private int startingCoins; // starting number of coins
    private int maxRounds; // maximum number of rounds played

    public CoinGame(int s, int r) {
        startingCoins = s;
        maxRounds = r;
    }

    /** Returns the number of coins (1, 2, or 3) that player 1 will spend. */
    public int getPlayer1Move(int strategy, int round) {
        switch(strategy){
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return (round % 3 == 0 ? 3 : (round % 2 == 0 ? 2 : 1));
            case 5:
                Random rand = new Random();
                return rand.nextInt(3) + 1;
        }
        return 1;
    }

    /** Returns the number of coins (1, 2, or 3) that player 2 will spend, as described in part (a). */
    public int getPlayer2Move(int round) {
        return (round % 3 == 0 ? 3 : (round % 2 == 0 ? 2 : 1));
    }

    /** Plays a simulated game between two players, as described in part (b).
     * @return*/
    public String[][][] playGame(int strategy) {
        int p1Coins, p2Coins, p1Move, p2Move;
        String[][] data = new String[1][5];
        p1Coins = p2Coins = startingCoins;
        int round = 1;

        while (round <= maxRounds && p1Coins > 2 && p2Coins > 2) {
            p1Move = getPlayer1Move(strategy, round);
            p2Move = getPlayer2Move(round);
            p1Coins -= p1Move;
            p2Coins -= p2Move;
            if (Math.abs(p1Move - p2Move) == 2) {
                p1Coins += 2;
            }
            else {
                p2Coins += 1;
            }

            if (round > data.length) {
                data = Arrays.copyOf(data, data.length + 1);
            }
            data[round - 1] = new String[]{String.valueOf(round), String.valueOf(p1Move), String.valueOf(p2Move), String.valueOf(p1Coins), String.valueOf(p2Coins)};

            round += 1;
        }
        return new String[][][] {data, {{(p1Coins == p2Coins ? "tie game" : (p1Coins > p2Coins ? "player 1 wins" : "player 2 wins"))}}};
     }

    public static void main(String[] args) {
        CoinGame game = new CoinGame(10, 5);
        System.out.println(Arrays.deepToString(game.playGame(1)));
    }
}