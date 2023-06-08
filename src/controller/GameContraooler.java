package controller;

import models.Game;
import models.GameStatus;
import models.Player;
import strategies.WinningStrategy.WinningStrategy;

import java.util.List;

public class GameContraooler {
    public Game createGame() {
        return null;
    }
    public void displayBoard(Game game) {
        game.printBoard();
    }
    public void undo() {

    }
    public void makeMove() {
        Player currentPlayer = players.get(cu);


    }
    public GameStatus getGameStatus() {

        return null;
    }
    public void printWinner(Game game) {
        game.printWinner();

    }

    public Game createGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {



        return Game.getBuilder().setDimesion(dimension).setPlayers(players).setWinningStrategy(winningStrategies).build();
    }
}
