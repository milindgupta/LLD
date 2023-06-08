package models;

import strategies.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    private List<Move> moves;
    private Board board;
    private List<Player> players;
    private int currrentMovePlayerIndex;
    private List<WinningStrategy> winningStrategy;
    private Player winner;
    int dimestion;
    public static Builder getBuilder() {
        return new Builder();
    }

    public Game(int  dimention, List<Player> players,List<WinningStrategy> winningStrategy) {
        this.moves = new ArrayList<>();
        this.board = new Board(dimention);
        this.players = players;
        this.currrentMovePlayerIndex = 0;
        this.winningStrategy = winningStrategy;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.dimestion = dimention;
//        this.winner = null;
    }


    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Builder setPlayers(List<Player> players) {
        this.players = players;
        return this;
    }

    public void setCurrrentMovePlayerIndex(int currrentMovePlayerIndex) {
        this.currrentMovePlayerIndex = currrentMovePlayerIndex;
    }

    public Builder setWinningStrategy(List<WinningStrategy> winningStrategy) {
        this.winningStrategy = winningStrategy;
        return this;
    }
    public Builder setDimention(int dimestion ) {
        this.dimestion = dimestion;
        return this;
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

    public void printBoard() {
        this.board.print();
    }
    public boolean valid() {
        if(this.players.size()<2) {
            return false;
        }
        if(this.players.size()!= this.dimestion-1){
            return false;
        }
        int botCount = 0;
        for(Player player: this.players) {
            if(player.getPlayerType().equals(PlayerType.BOT)) {
                botCount+=1;
            }
        }
        if(botCount>=2){
            return false;
        }

        Set<Character> existingSymbils = new HashSet<>();
        for(Player player: players) {
            if(existingSymbils.contains(player.getSymbol().getAchar())) return false;

            existingSymbils.add(player.getSymbol().getAchar());
        }
        return true;

    }
    public Game build() {

        return new Game(dimestion, players, winningStrategy);
    }
    public static class Builder{
        private List<Player> players;
        private List<WinningStrategy> winningStrategy;
        private int dimention;
        private Builder() {

        }
    }

    private boolean validateMove(Cell cell) {
        int row = cell.getRow();int col = cell.getColumn();
        if(row>=board.getSize() || row<0 | col < 0|| col>= board.getSize()) {
            return false;
        }

            return true;

    }
    public void makeMove(){
        Player currentPlayer = players.get(currrentMovePlayerIndex);
        Cell proposedCell = currentPlayer.makeMove();
        if(!validateMove(proposedCell)) {
            return;
        }
        Cell cellingBoard = board.getBoard().get(proposedCell.getRow()).get(proposedCell.getColumn());
        cellingBoard.setCellState(CellState.EMPTY);
        cellingBoard.setPlayer(currentPlayer);
        Move move - new Move(currentPlayer, cellingBoard);
        moves.add(move);
        for(WinningStrategy winningStrategy: winningStrategy) {
            if(winningStrategy.checkWinner(board, moves)) {
                gameStatus = GameStatus.ENDED;
                winner = currentPlayer;
                return;
            }
        }
        if(move.size() == board.getSize() + board.getSize()) {
            gameStatus = GameStatus.DRAW;
            return;
        }
        currrentMovePlayerIndex + =1;
        currrentMovePlayerIndex %= players.size();
    }

    public void printWinner() {
        System.out.println(winner);
    }

    public void printResult() {
        if(gameStatus.equals(GameStatus.ENDED)) {
            System.out.println("game has ended";
            System.out.println("winner is "+ winner.getName());
        }
    }

}
