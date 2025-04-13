import java.util.Scanner;

public class Game {
    private HumanPlayer player;
    private AIPlayer computer;
    private boolean gameOver=false;

    //متدی برا شروع بازی  شامل راه اندازی و اجرا حلقه بازی
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            setup();
            playGame();
            playAgain = askReplay(scanner);
        }
        while (playAgain);
        System.out.println("Thanks for playing!");
    }

    //متد راه اندازی بازی ساخت بازیکنو جایگذاری کشتی ها
    private void setup(){
        player=new HumanPlayer("You");
        computer = new AIPlayer("Computer");
        System.out.println("Placing your ships...");
        player.placeShips();

        System.out.println("Placing computer's ships...");
        computer.placeShips();

        gameOver = false;
    }

    //اجرای نوبت‌های بازی تا زمانی که یکی از بازیکنان ببازد
    private void playGame() {
        while (!gameOver) {
            playerTurn();


            if (computer.hasLost()) {
                System.out.println("🎉 You won!");
                gameOver = true;
                break;
            }

            if (player.hasLost()) {
                System.out.println("💀 Computer won!");
                gameOver = true;
            }

        }
    }

    // متد اجرای نوبت بازیکن
    private void playerTurn() {
        System.out.println("\nYour turn:");
        player.makeMove(computer.getBoard()); // بازیکن یک حرکت انجام می‌دهد روی برد کامپیوتر
    }

    private void computerTurn() {
        System.out.println("\nComputer's turn:");
        computer.makeMove(player.getBoard()); // کامپیوتر یک حرکت انجام می‌دهد روی برد بازیکن
    }

    // سوال از کاربر برای بازی مجدد
    private boolean askReplay(Scanner scanner) {
        System.out.print("\nPlay again? (yes/no): ");
        return scanner.nextLine().trim().equalsIgnoreCase("yes"); // بازگشت true اگر کاربر "yes" وارد کند
    }









}
