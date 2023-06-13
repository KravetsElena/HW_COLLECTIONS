package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(23, "Ivan", 250);
    Player player2 = new Player(15, "Oleg", 100);
    Player player3 = new Player(10, "Olga", 100);


    @Test
    public void WinPlayer1() {
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Ivan", "Oleg");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void WinPlayer2() {

        game.register(player3);
        game.register(player1);
        int expected = 2;
        int actual = game.round("Olga", "Ivan");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void drawnGame() {
        game.register(player3);
        game.register(player2);
        int expected = 0;
        int actual = game.round("Olga", "Oleg");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void Player1NotRegistered() {
        game.register(player3);
        game.register(player2);
        game.register(player1);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Ilya", "Oleg"));

    }

    @Test
    public void Player2NotRegistered() {
        game.register(player3);
        game.register(player2);
        game.register(player1);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Olga", "Semen"));

    }

    @Test
    public void BothPlayersNotRegistered() {
        game.register(player3);
        game.register(player2);
        game.register(player1);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Ilya", "Semen"));

    }

}
