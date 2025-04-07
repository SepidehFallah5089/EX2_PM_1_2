import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class EX2_PM_3_2 extends JFrame implements KeyListener {

    private int k; // اندازه ماتریس
    private char[][] array; // ماتریس بازی
    private int pacmanRow = 1; // موقعیت سطر Pac-Man
    private int pacmanCol = 1; // موقعیت ستون Pac-Man
    private int score = 0; // امتیاز
    final int width = 400, height = 400, boxSize = 20;
    private Random random = new Random();

    public EX2_PM_3_2(int k) {
        this.k = k;
        initializeGame();

        addKeyListener(this);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeGame() {
        array = new char[k + 2][k + 2];

        // مقداردهی ماتریس
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                if (i == 0 || i == k + 1 || j == 0 || j == k + 1) {
                    array[i][j] = '*';
                } else {
                    array[i][j] = ' ';
                }
            }
        }

        // تولید نقاط امتیازدهی به صورت تصادفی
        for (int i = 0; i < k; i++) {
            int x, y;
            do {
                x = random.nextInt(k) + 1;
                y = random.nextInt(k) + 1;
            } while (array[x][y] != ' ');
            array[x][y] = '.';
        }

        // تنظیم موقعیت اولیه Pac-Man
        array[pacmanRow][pacmanCol] = 'X';
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g.clearRect(0, 0, width, height);

        drawMatrix(g2D);
        drawScore(g2D);
    }

    private void drawMatrix(Graphics2D g2D) {
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                if (array[i][j] == '*') {
                    g2D.setColor(Color.BLACK); // دیواره‌ها
                } else if (array[i][j] == '.') {
                    g2D.setColor(Color.RED); // نقاط امتیاز
                } else if (array[i][j] == 'X') {
                    g2D.setColor(Color.BLUE); // Pac-Man
                } else {
                    g2D.setColor(Color.WHITE); // فضای خالی
                }
                g2D.fillRect(j * boxSize, i * boxSize, boxSize, boxSize);
            }
        }
    }

    private void drawScore(Graphics2D g2D) {
        g2D.setColor(Color.BLACK);
        g2D.drawString("Score: " + score, 10, 20);
    }

    private void movePacman(char direction) {
        array[pacmanRow][pacmanCol] = ' ';
        switch (direction) {
            case 'w': // بالا
                if (pacmanRow - 1 > 0) {
                    pacmanRow--;
                } else {
                    System.out.println("برخورد با دیواره: hitting the game wall");
                }
                break;
            case 'd': // راست
                if (pacmanCol + 1 < k + 1) {
                    pacmanCol++;
                } else {
                    System.out.println("برخورد با دیواره: hitting the game wall");
                }
                break;
            case 's': // پایین
                if (pacmanRow + 1 < k + 1) {
                    pacmanRow++;
                } else {
                    System.out.println("برخورد با دیواره: hitting the game wall");
                }
                break;
            case 'a': // چپ
                if (pacmanCol - 1 > 0) {
                    pacmanCol--;
                } else {
                    System.out.println("برخورد با دیواره: hitting the game wall");
                }
                break;
            default:
                System.out.println("دستور نامعتبر! لطفا فقط از w، d، s، یا a استفاده کنید.");
        }

        // بررسی برخورد با نقاط امتیاز
        if (array[pacmanRow][pacmanCol] == '.') {
            score++;
            System.out.println("Score updated: " + score);
        }

        array[pacmanRow][pacmanCol] = 'X';
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        movePacman(e.getKeyChar());
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        int k = 10; // اندازه ماتریس
        new EX2_PM_3_2(k);
    }
}

