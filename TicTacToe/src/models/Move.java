package TicTacToe.src.models;

public class Move {
    Cell cell;
    Player player;

    public Move(Cell c, Player p){
        this.cell=c;
        this.player=p;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
}
