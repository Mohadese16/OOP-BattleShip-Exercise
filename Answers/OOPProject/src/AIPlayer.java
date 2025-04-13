import java.util.Random;

public class AIPlayer extends Player {
    private Random random = new Random();

    public AIPlayer(String name) {
        super(name, 10);
    }

    @Override
    public void placeShips() {
        for (Ship ship : ShipFactory.getDefaultShips()) {
            boolean placed = false;
            while (!placed) {
                int row = random.nextInt(board.getSize());
                int col = random.nextInt(board.getSize());
                boolean horizontal = random.nextBoolean();
                placed = board.placeShip(ship, row, col, horizontal);
                if (placed) {
                    ships.add(ship);
                }
            }
        }
        System.out.println("Computer has placed its ships.");
    }

    @Override
    public void makeMove(Board enemyBoard) {
        boolean validMove = false;
        while (!validMove) {
            int row = random.nextInt(board.getSize());
            int col = random.nextInt(board.getSize());
            validMove = enemyBoard.receiveAttack(row, col);
            if (validMove) {
                System.out.println("Computer attacks " + (char)(col + 'A') + row);
            }
        }
    }
}
