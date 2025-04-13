import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardPanel extends JPanel {
    private JButton[][] buttons; // دکمه‌ها برای هر خانه بورد
    private final int SIZE = 10;  // اندازه بورد (۱۰x۱۰)

    public BoardPanel() {
        setLayout(new GridLayout(SIZE, SIZE)); // 10x10 grid برای نمایش خانه‌ها
        buttons = new JButton[SIZE][SIZE];

        // پر کردن بورد با دکمه‌ها
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(50, 50));
                buttons[i][j].setBackground(Color.CYAN);
                buttons[i][j].setEnabled(true); // دکمه‌ها فعال
                buttons[i][j].addActionListener(new ButtonClickListener(i, j)); // هر دکمه کلیک‌پذیر
                add(buttons[i][j]);
            }
        }
    }

    // Listener برای واکنش به کلیک‌های ماوس
    private class ButtonClickListener implements ActionListener {
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Clicked on: " + (char) ('A' + row) + (col + 1));
            // متد برای ثبت حمله بر اساس مختصات
        }
    }

    // متدی برای آپدیت وضعیت خانه‌ها (مثلاً وقتی کشتی زده می‌شود)
    public void updateCell(int row, int col, String status) {
        // بررسی وضعیت خانه و تغییر رنگ
        if (status.equals("hit")) {
            buttons[row][col].setBackground(Color.RED);
        } else if (status.equals("miss")) {
            buttons[row][col].setBackground(Color.GRAY);
        } else {
            buttons[row][col].setBackground(Color.CYAN);
        }
    }
}
