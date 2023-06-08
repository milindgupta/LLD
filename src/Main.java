import controller.GameContraooler;
import models.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameContraooler gameContraooler = new GameContraooler();
        Game game = gameContraooler.createGame(3, Listof(new Player((new Symbol('x'), 'sjdf', PlayerType.HUMAN)));

        Scanner scanner = new Scanner(System.in);

        while(gameContraooler.getGameStatus().equals(GameStatus.IN_PROGRESS)) {
            gameContraooler.displayBoard();

            System.out.print("do you want to undo? (y/n)");
            String input = scanner.next();
            if(input.equalsIgnoreCase("y")){
                gameContraooler.undo();
            } else {
                gameContraooler.makeMove();
            }
            GameStatus gameStatus = gameContraooler.getGameStatus();

            if(gameStatus.equals(GameStatus.ENDED)) {
                gameContraooler.printWinner();
            } else {
                System.out.print("Game is draw");
            }
        }
    }
}
