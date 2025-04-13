public class Board {
    private final int size;
    private final Cell[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new Cell[size][size];

        // مقداردهی اولیه سلول‌ها
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public int getSize() {
        return size;
    }

    public boolean placeShip(Ship ship, int row, int col, boolean horizontal) {
        int length = ship.getLength();

        // بررسی مرزها
        if (horizontal) {
            if (col + length > size) return false;
        } else {
            if (row + length > size) return false;
        }

        // بررسی تداخل با کشتی‌های دیگر
        for (int i = 0; i < length; i++) {
            int r = row + (horizontal ? 0 : i);
            int c = col + (horizontal ? i : 0);
            if (grid[r][c].hasShip()) return false;
        }

        // جای‌گذاری کشتی
        for (int i = 0; i < length; i++) {
            int r = row + (horizontal ? 0 : i);
            int c = col + (horizontal ? i : 0);
            grid[r][c].placeShip(ship);
            ship.addPosition(r, c);
        }

        return true;
    }

    public boolean receiveAttack(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) return false;
        Cell cell = grid[row][col];

        if (cell.isAttacked()) return false; // قبلاً زده شده

        cell.attack();
        if (cell.hasShip()) {
            cell.getShip().hit();
            System.out.println("💥 Hit!");
        } else {
            System.out.println("💦 Miss!");
        }
        return true;
    }

    public void display(boolean showShips) {
        System.out.print("  ");
        for (int c = 0; c < size; c++) {
            System.out.print((char) ('A' + c) + " ");
        }
        System.out.println();

        for (int r = 0; r < size; r++) {
            System.out.print(r + " ");
            for (int c = 0; c < size; c++) {
                System.out.print(grid[r][c].getDisplayChar(showShips) + " ");
            }
            System.out.println();
        }
    }
}
