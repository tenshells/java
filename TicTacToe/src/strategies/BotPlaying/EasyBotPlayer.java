package TicTacToe.src.strategies.BotPlaying;

import java.util.List;

import TicTacToe.src.models.Board;
import TicTacToe.src.models.Cell;
import TicTacToe.src.models.CellState;
import TicTacToe.src.models.Move;
import TicTacToe.src.strategies.BotPlayingStrategy;

public class EasyBotPlayer implements BotPlayingStrategy{

    @Override
    public Move makeMove(Board b) {
        // TODO Auto-generated method stub
        for(List<Cell> lc : b.getBoard()){
            for(Cell c : lc){
                if(c.getCellState().equals(CellState.EMPTY)){
                    return new Move(c,null);
                }
            }
        }

        return null;

    }
}
