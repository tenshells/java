package TicTacToe.src.exceptions;

import p.p;

public class DuplicateSymbolException extends Exception{

    public DuplicateSymbolException(String string) {
        p.printl(string);
    }
    
}
