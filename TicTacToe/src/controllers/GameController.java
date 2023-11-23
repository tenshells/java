package TicTacToe.src.controllers;

import java.util.List;
import java.util.Scanner;

import TicTacToe.src.exceptions.DuplicateSymbolException;
import TicTacToe.src.exceptions.InvalidBoardSizeOrPlayerCountException;
import TicTacToe.src.exceptions.TooBigBoardException;
import TicTacToe.src.exceptions.TooManyBotsException;
import TicTacToe.src.models.Game;
import TicTacToe.src.models.Player;
import TicTacToe.src.strategies.WinningStrategy;
import p.p;

public class GameController {
    
    public Game startGame(int size, List<Player> p, List<WinningStrategy> ws){
        //call Game Builder with params

        Game g = null;
        try {
            g = Game.getBuilder().setBplayers(p).setBsize(size).setbStrategies(ws).build();

        } catch (DuplicateSymbolException | InvalidBoardSizeOrPlayerCountException | TooBigBoardException
                | TooManyBotsException e) {
            System.out.println("Please restart Game... ");
        }

        return g;
    }

    public void showBoard(Game g){
        g.showBoard();
    }

    public void makeMove(Game g){
        g.makeMove();
    }

    public static void showRules(){
        p.printl("Hi, welcome to Shelton's X and O.");
        p.printl("These are the rules of the game: ");
        p.printl("Board will be of size n*n where 1>=n>=10. ");
        p.printl("Only one bot allowed. Only Easy Mode availible. ");
    }

    public boolean askForUndo(Game g) {
        return g.askForUndo();
    }


}
