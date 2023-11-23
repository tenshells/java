package TicTacToe.src.strategies.Winning;

import java.util.HashMap;

import TicTacToe.src.models.Board;
import TicTacToe.src.models.Move;
import TicTacToe.src.models.Symbol;
import TicTacToe.src.strategies.WinningStrategy;

public class DiagWinningStrategy implements WinningStrategy{

    HashMap<Symbol,Integer> diag;
    HashMap<Symbol,Integer> antiDiag;

    public DiagWinningStrategy(){
        this.diag=new HashMap<>();
        this.antiDiag=new HashMap<>();
    }

    @Override
    public boolean checkWinner(Board b, Move m) {

        int r = m.getCell().getRow();
        int c = m.getCell().getCol();
        Symbol s = m.getPlayer().getSymbol();
        int filledCount = b.getSize();

        if(r+c == b.getSize()-1){
            diag.put(s,diag.getOrDefault(s, 0)+1);
        }
        
        if(r == c){
            antiDiag.put(s,antiDiag.getOrDefault(s, 0)+1);
        }

        if(r+c==b.getSize()-1){
            if(diag.get(s)==filledCount)
                return true;
        }

        if(r==c){
            if(antiDiag.get(s)==filledCount)
                return true;
        }

        return false;

    }

    @Override
    public void handleUndo(Board b, Move m) {
        Symbol s = m.getPlayer().getSymbol();
        int r = m.getCell().getRow();
        int c = m.getCell().getCol();

        if(r==c){
            antiDiag.put(s,antiDiag.get(s)-1);
        }

        if(r+c == b.getSize()-1){
            diag.put(s,diag.get(s)-1);
        }

    }
    
}
