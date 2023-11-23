package TicTacToe.src.models;

public class Cell {
    int row;
    int col;

    Player player;
    Symbol symbol;

    CellState cellState;

    Cell(int i, int j){
        row=i;
        col=j;

        this.setCellState(CellState.EMPTY);
    }

    public CellState getCellState() {
        return cellState;
    }
    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public Symbol getSymbol() {
        return symbol;
    }
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public void display() {
        if(cellState==CellState.EMPTY)
            System.out.print("| - |");
        else
            System.out.print("| "+player.getSymbol().symbol+" |");
    }
}
