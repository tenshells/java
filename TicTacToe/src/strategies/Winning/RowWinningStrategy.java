package TicTacToe.src.strategies.Winning;

import java.util.HashMap;

import TicTacToe.src.models.Board;
import TicTacToe.src.models.Move;
import TicTacToe.src.models.Symbol;
import TicTacToe.src.strategies.WinningStrategy;
import p.p;

public class RowWinningStrategy implements WinningStrategy{

    HashMap<Integer,HashMap<Symbol,Integer>> rowCount;

    public RowWinningStrategy(){
        rowCount = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Board b, Move m) {
        // TODO Auto-generated method stub");   
        int row = m.getCell().getRow();
        Symbol s = m.getPlayer().getSymbol();

        if(!rowCount.containsKey(row))
            rowCount.put(row,new HashMap<>());
        
        HashMap<Symbol,Integer> SymbolCountInRow = rowCount.get(row);

        SymbolCountInRow.put(s,SymbolCountInRow.getOrDefault(s, 0)+1);

        if(SymbolCountInRow.get(s)==b.getSize())
            return true;
        return false;

    }
    
    @Override
    public void handleUndo(Board b, Move m) {
        Symbol s = m.getPlayer().getSymbol();
        int r = m.getCell().getRow();
        p.printl("Undoing the last move at "+m.getCell().getRow()+","+m.getCell().getCol()+" : "+m.getPlayer().getSymbol().getSymbol());

        rowCount.get(r).put(s,rowCount.get(r).get(s)-1);
    }
}
