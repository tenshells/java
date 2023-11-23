package TicTacToe.src.exceptions;

import p.p;

public class TooManyBotsException extends Exception{

    public TooManyBotsException(String string) {
        p.printl(string);
    }
    
}
