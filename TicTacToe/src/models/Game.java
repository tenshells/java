package TicTacToe.src.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import TicTacToe.src.exceptions.DuplicateSymbolException;
import TicTacToe.src.exceptions.InvalidBoardSizeOrPlayerCountException;
import TicTacToe.src.exceptions.TooBigBoardException;
import TicTacToe.src.exceptions.TooManyBotsException;
import TicTacToe.src.strategies.WinningStrategy;
import p.p;

public class Game {
    int size;
    Board board;
    List<Player> players;
    int nextPlayerToMove;    
    List<WinningStrategy> strategies;
    List<Move> moves;
    Player winner;
    GameState gameState;

    private Game(int size, List<Player> lp, List<WinningStrategy> lws){
        this.size=size;
        board = new Board(size);
        this.players=lp;
        this.nextPlayerToMove=0;
        this.strategies=lws;
        this.moves=new ArrayList<>();
        gameState=GameState.IN_PROGRESS;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
    
    public void showBoard(){
        for(List<Cell> lc : board.board){
            for(Cell c: lc){
                c.display();
            }

            System.out.println("\n");
        }
    }

    private boolean validateMove(Move m){

        int cr = m.getCell().getRow();
        int cc = m.getCell().getCol();

        if(cr<0 || cr >=(size) || cc<0 || cc>=(size))
            return false;

        if(board.board.get(cr).get(cc).getCellState().equals(CellState.FILLED))
            return false;
        
        return true;
    }

    public void makeMove(){
        Player pp = players.get(nextPlayerToMove);
        p.printl("It's "+pp.getName()+"'s turn ! ");
        Move chosenMove = pp.makeMove(board);

        if(!validateMove(chosenMove)){
            System.out.println("Invalid move! Try Again! ");
            return;
        }

        Cell chosenCell = board.getBoard().get(chosenMove.getCell().getRow()).get(chosenMove.getCell().getCol());
        chosenCell.setPlayer(pp);

        board.makeMove(chosenMove);
        moves.add(chosenMove);

        for (WinningStrategy ws : strategies){
            if(ws.checkWinner(board,chosenMove)){
                this.setGameState(GameState.WON);
                this.winner=pp;
            }
        }

        if(moves.size() == size*size)
            this.setGameState(GameState.DRAW);

        this.nextPlayerToMove = (this.nextPlayerToMove + 1) % players.size();

    }

    public boolean askForUndo(){
        if(moves.size()==0)
            return false;

        p.printl("Do you wish to undo ? ");
        Scanner s = new Scanner(System.in);
        String undo = s.next();
        s.close();
        if(undo.equalsIgnoreCase("Y")){
            doUndo();
            return true;
        }
        return false;
    }

    private void doUndo(){
        Move lastMove = moves.get(moves.size()-1);
        moves.remove(lastMove);
        
        int r = lastMove.getCell().getRow();
        int c = lastMove.getCell().getCol();

        for(WinningStrategy ws : strategies){
            ws.handleUndo(board,lastMove);
        }

        board.getBoard().get(r).get(c).setCellState(CellState.EMPTY);
        board.getBoard().get(r).get(c).setPlayer(null);

        nextPlayerToMove = (nextPlayerToMove - 1 + players.size())%players.size();
    }
    

    public static class Builder{
        int bsize;
        List<Player> bplayers;
        List<WinningStrategy> bStrategies;

        public Builder setBplayers(List<Player> bplayers) {
            this.bplayers = bplayers;
            return this;
        }

        public Builder setbStrategies(List<WinningStrategy> bStrategies) {
            this.bStrategies = bStrategies;
            return this;
        }

        private Builder addPlayer(Player p){
            bplayers.add(p);
            return this;
        }

        private Builder addStrategy(WinningStrategy ws){
            bStrategies.add(ws);
            return this;
        }

        public Builder setBsize(int bsize) {
            this.bsize = bsize;
            return this;
        }

        private void validateAll() throws TooBigBoardException, InvalidBoardSizeOrPlayerCountException, TooManyBotsException, DuplicateSymbolException{
            validateBoardSize();
            validateBotCount();
            validateUniqueSymbols();
        }

        private void validateBoardSize() throws TooBigBoardException, InvalidBoardSizeOrPlayerCountException{
            if(bsize>10)
                throw new TooBigBoardException();
            if(bsize!=bplayers.size()+1)
                throw new InvalidBoardSizeOrPlayerCountException();
        }

        private void validateBotCount() throws TooManyBotsException{
            int bc = 0;
            for(Player p : bplayers){
                if(p.getPlayerType().equals(PlayerType.BOT))
                    bc++;
            }

            if(bc>1)
                throw new TooManyBotsException("Too many Bots, only one bot allowed. ");
        }

        private void validateUniqueSymbols() throws DuplicateSymbolException{
            
            HashSet<Character> hs = new HashSet<>();

            for(Player p: bplayers){
                if(hs.contains(p.getSymbol().getSymbol())){
                    throw new DuplicateSymbolException("Got a duplicate symbol of "+p.getSymbol().symbol+", please restart game. ");
                }
                hs.add(p.getSymbol().getSymbol());
            }
        }

        public Game build() throws DuplicateSymbolException, InvalidBoardSizeOrPlayerCountException, TooBigBoardException, TooManyBotsException {
            validateAll();
            System.out.println("Game validated. Starting game.. ");
            return new Game(bsize,bplayers,bStrategies);
        }

    }

}
