package ru.netology;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {
        super(playerName);
    }
}
