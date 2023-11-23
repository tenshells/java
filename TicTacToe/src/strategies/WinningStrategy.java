package TicTacToe.src.strategies;

import TicTacToe.src.models.Board;
import TicTacToe.src.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board b, Move m);

    void handleUndo(Board b, Move m);
}
