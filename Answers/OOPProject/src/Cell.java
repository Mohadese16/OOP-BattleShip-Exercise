public class Cell {
    private boolean attacked;
    private Ship ship;

    public boolean hasShip() {
        return ship != null;
    }

    public void placeShip(Ship ship) {
        this.ship = ship;
    }

    public boolean isAttacked() {
        return attacked;
    }

    public void attack() {
        attacked = true;
    }

    public Ship getShip() {
        return ship;
    }

    public char getDisplayChar(boolean showShip) {
        if (attacked) {
            if (hasShip()) return 'X'; // hit
            else return 'O'; // miss
        } else {
            if (hasShip() && showShip) return 'S';
            else return '.';
        }
    }
}
