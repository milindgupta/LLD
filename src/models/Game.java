package models;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Move> moves;
    private Board board;
    private List<Player> players;
    private int currrentMovePlayerIndex;
    private List<WinningStrategy> winningStrategy;

    public Game(int  dimention, List<Player> players,List<WinningStrategy> winningStrategy) {
        this.moves = new ArrayList<>();
        this.board = new Board(dimention);
        this.players = players;
        this.currrentMovePlayerIndex = 0;
        this.winningStrategy = winningStrategy;
        this.gameStatus = GameStatus.IN_PROGRESS;
//        this.winner = null;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setCurrrentMovePlayerIndex(int currrentMovePlayerIndex) {
        this.currrentMovePlayerIndex = currrentMovePlayerIndex;
    }

    public void setWinningStrategy(List<WinningStrategy> winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    private GameStatus gameStatus;

    public List<Move> getMoves() {
        return moves;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getCurrrentMovePlayerIndex() {
        return currrentMovePlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategy() {
        return winningStrategy;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    private Player winner;

}
