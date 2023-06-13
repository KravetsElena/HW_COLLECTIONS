package ru.netology;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }
    

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;

        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }

        }


        if (player1 == null) {
            throw new NotRegisteredException(
                    "Element with id: " + playerName1 + " not found");
        }
        if (player2 == null) {
            throw new NotRegisteredException(
                    "Element with id: " + playerName2 + " not found");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}

