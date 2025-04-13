
import java.util.ArrayList;
import java.util.List;


public abstract class Player {
    protected String name;
    protected Board board;
    protected List<Ship> ships;

    public Player(String name, int boardSize) {
        this.name = name;
        this.board = new Board(boardSize);
        this.ships = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public boolean hasLost() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;

    }

    public abstract void placeShips();
    public abstract void makeMove(Board enemyBoard);











}
