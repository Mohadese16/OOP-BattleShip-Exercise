import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private Game game; // اشاره به شیء بازی

    public GameWindow() {
        // تنظیمات اولیه پنجره بازی
        setTitle("Battleship Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // وسط صفحه نمایش داده بشه

        // ایجاد شیء از بازی
        game = new Game();

        // نمایش پنجره
        setVisible(true);

        // شروع بازی
        game.start();
    }

}