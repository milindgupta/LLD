package strategies.WinningStrategy;

import models.Board;
import models.Move;

public class OrderOneColWinningStrategy implements  WinningStrategy{

    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
