package TicTacToe.src.strategies.Winning;

import java.util.HashMap;

import TicTacToe.src.models.Board;
import TicTacToe.src.models.Move;
import TicTacToe.src.models.Symbol;
import TicTacToe.src.strategies.WinningStrategy;

public class ColWinningStrategy implements WinningStrategy {
    
    HashMap<Integer,HashMap<Symbol,Integer>> colCount;

    public ColWinningStrategy(){
        colCount = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Board b, Move m) {
        // TODO Auto-generated method stub");   
        int col = m.getCell().getCol();
        Symbol s = m.getPlayer().getSymbol();

        if(!colCount.containsKey(col))
            colCount.put(col,new HashMap<>());
        
        HashMap<Symbol,Integer> SymbolCountInCol = colCount.get(col);

        SymbolCountInCol.put(s,SymbolCountInCol.getOrDefault(s, 0)+1);

        if(SymbolCountInCol.get(s)==b.getSize())
            return true;
        return false;

    }

    @Override
    public void handleUndo(Board b, Move m) {
        Symbol s = m.getPlayer().getSymbol();
        int c = m.getCell().getCol();

        colCount.get(c).put(s,colCount.get(c).get(s)-1);
    }
}
