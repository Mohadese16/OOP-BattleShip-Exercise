import java.util.ArrayList;
import java.util.List;

public class Ship {
    private String name;
    private int length;
    private int hits;
    private List<int[]> positions;

    public Ship(String name, int length) {
        this.name = name;
        this.length = length;
        this.hits = 0;
        this.positions = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public int getLength(){
        return length;
    }

    public void hit(){
        hits++;
    }

    public boolean isSunk(){
        return hits>=length;
    }

    public void addPosition(int row, int col) {
        positions.add(new int[]{row, col});
    }

    public List<int[]> getPositions() {
        return positions;
    }
    @Override
    public String toString() {
        return name + " (" + length + ") - Hits: " + hits + "/" + length + (isSunk() ? " [SUNK]" : "");
    }

}
