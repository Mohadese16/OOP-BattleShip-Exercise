import java.util.ArrayList;
import java.util.List;

public class ShipFactory {
    public static List<Ship> getDefaultShips() {
        List<Ship> ships = new ArrayList<>();
        ships.add(new Ship("Carrier", 5));
        ships.add(new Ship("Battleship", 4));
        ships.add(new Ship("Cruiser", 3));
        ships.add(new Ship("Submarine", 3));
        ships.add(new Ship("Destroyer", 2));
        return ships;
    }
}
