package TicTacToe.src.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    List<List<Cell>> board;

    public List<List<Cell>> getBoard() {
        return board;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Board(int size) {
        this.size=size;
        board = new ArrayList<>();
        for(int i=0;i<size;i++){
            board.add(new ArrayList<Cell>());
            for(int j=0;j<size;j++){
                board.get(i).add(new Cell(i,j));
            }
        }
    }

    public void makeMove(Move chosenMove) {
        int cr = chosenMove.getCell().getRow();
        int cc = chosenMove.getCell().getCol();

        board.get(cr).get(cc).setCellState(CellState.FILLED);
        board.get(cr).get(cc).setPlayer(chosenMove.getPlayer());
    }

}
