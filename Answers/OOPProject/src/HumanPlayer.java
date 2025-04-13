import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String name) {
        super(name, 10);
        scanner = new Scanner(System.in);
    }

    @Override
    public void placeShips() {
        System.out.println("\nPlace your ships:");
        for (Ship ship : ShipFactory.getDefaultShips()) {
            boolean placed = false;
            while (!placed) {
                System.out.println("Enter position for " + ship.getName() + " (length: " + ship.getLength() + ") e.g. A5 H:");
                String input = scanner.nextLine().toUpperCase();
                String[] parts = input.split(" ");
                if (parts.length != 2 || !InputValidator.isValidCoordinate(parts[0]) || !InputValidator.isValidOrientation(parts[1])) {
                    System.out.println("Invalid input. Try again.");
                    continue;
                }

                int row = parts[0].charAt(1) - '0';
                int col = parts[0].charAt(0) - 'A';
                boolean horizontal = parts[1].equals("H");

                placed = board.placeShip(ship, row, col, horizontal);
                if (!placed) {
                    System.out.println("Cannot place ship here. Try again.");
                } else {
                    ships.add(ship);
                    board.display(true);
                }
            }
        }
    }

    @Override
    public void makeMove(Board enemyBoard) {
        boolean validMove = false;
        while (!validMove) {
            System.out.print("Enter coordinate to attack (e.g. B3): ");
            String input = scanner.nextLine().toUpperCase();
            if (!InputValidator.isValidCoordinate(input)) {
                System.out.println("Invalid coordinate. Try again.");
                continue;
            }

            int row = input.charAt(1) - '0';
            int col = input.charAt(0) - 'A';
            validMove = enemyBoard.receiveAttack(row, col);
            if (!validMove) {
                System.out.println("This cell was already attacked. Try another.");
            }
        }
    }
}
