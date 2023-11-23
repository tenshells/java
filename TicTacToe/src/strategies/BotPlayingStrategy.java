package TicTacToe.src.strategies;

import TicTacToe.src.models.Board;
import TicTacToe.src.models.Move;

public interface BotPlayingStrategy {
    Move makeMove(Board b);
}
