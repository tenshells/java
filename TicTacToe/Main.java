package TicTacToe;

import java.util.ArrayList;
import java.util.List;

import TicTacToe.src.controllers.GameController;
import TicTacToe.src.models.Game;
import TicTacToe.src.models.GameState;
import TicTacToe.src.models.Player;
import TicTacToe.src.strategies.WinningStrategy;
import TicTacToe.src.strategies.Winning.ColWinningStrategy;
import TicTacToe.src.strategies.Winning.DiagWinningStrategy;
import TicTacToe.src.strategies.Winning.RowWinningStrategy;
import p.p;

public class Main {
    public static void main(String[] args) {
        GameController.showRules();

        GameController gc = new GameController();
        
        List<Player> lp = new ArrayList<>();
        lp.add(new Player(1,"Arun",'X'));
        lp.add(new Player(2,"Mohit",'0'));

        List<WinningStrategy> lw = new ArrayList<>();
        lw.add(new RowWinningStrategy());
        lw.add(new ColWinningStrategy());
        lw.add(new DiagWinningStrategy());

        Game g = gc.startGame(3,lp,lw);
        gc.showBoard(g);

        while(g.getGameState().equals(GameState.IN_PROGRESS)){
            if(gc.askForUndo(g)){
                gc.showBoard(g);
                continue;
            }
            gc.makeMove(g);
            gc.showBoard(g);
        }


        if(g.getGameState().equals(GameState.WON)){
            p.printl("We have a winner!  It's " + g.getWinner().getName()) ;
            gc.showBoard(g);
        }
        else if(g.getGameState().equals(GameState.DRAW)){
            p.printl("It's a draw !  : ) ");
        }
        
    }
}
