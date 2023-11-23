package TicTacToe.src.models;

import java.util.Scanner;

import p.p;

public class Player {
    private int id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private Scanner scanner;

    public Player(int id, String name, char symbol){
        this.id=id;
        this.name=name;
        this.symbol = new Symbol(symbol);
        this.playerType=PlayerType.HUMAN;
        this.scanner = new Scanner(System.in);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }
    
    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board b){
        p.printl(this.getName()+", choose the row where you want to place your symbol : ");
        int r = scanner.nextInt();
        p.printl(this.getName()+", choose the column where you want to place your symbol : ");
        int c = scanner.nextInt();

        return new Move(new Cell(r, c),this);
    }
}
