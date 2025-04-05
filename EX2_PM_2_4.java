import java.io.*;
import java.util.Random;

public class EX2_PM_2_4 {
    public static void main(String[] args) {

        int k = 9; // مقدار مربوط به EX2_PM_1_1 و EX2_PM_1_2
        int c = 15; // مقدار مربوط به EX2_PM_1_3

        Random rnd = new Random();

        PacmanEngine pacmanEngine = new PacmanEngine(k, c);

        while (true) {
            pacmanEngine.printMatrix(); // چاپ ماتریس
            pacmanEngine.printScore(); // چاپ امتیاز
            pacmanEngine.printRemainTime(); // چاپ زمان باقی‌مانده

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            int direction = rnd.nextInt(4);
            pacmanEngine.move(direction); // حرکت نقطه خوار
            pacmanEngine.save(); // ذخیره بازی
        }
    }
}

class PacmanEngine {
    private int k;
    private int c;
    private int xRow;
    private int xCol;
    private int score;
    private long startTime;
    private char[][] array;
    private final File saveFile = new File("game_save.txt");

    public PacmanEngine(int k, int c) {
        this.k = k;
        this.c = c;

        if (saveFile.exists()) {
            load();
        } else {
            initializeGame();
        }

        this.startTime = System.currentTimeMillis();
    }

    private void initializeGame() {
        array = new char[k + 2][k + 2];
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                if (i == 0 || i == k + 1 || j == 0 || j == k + 1) {
                    array[i][j] = '*';
                } else {
                    array[i][j] = ' ';
                }
            }
        }

        Random random = new Random();
        int count = 0;
        while (count < c) {
            int randomRow = random.nextInt(k) + 1;
            int randomCol = random.nextInt(k) + 1;

            if (array[randomRow][randomCol] == ' ') {
                array[randomRow][randomCol] = '.';
                count++;
            }
        }

        xRow = 1;
        xCol = 1;
        array[xRow][xCol] = 'X';
        score = 0;
    }

    public void printMatrix() {
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    public void printScore() {
        System.out.println("امتیاز: " + score);
    }

    public void printRemainTime() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - startTime;
        System.out.println("زمان سپری‌شده: " + elapsedTime / 1000 + " ثانیه");
    }

    public void move(int direction) {
        array[xRow][xCol] = ' ';

        switch (direction) {
            case 0: // بالا
                if (xRow - 1 > 0) xRow--;
                else System.out.println("برخورد با دیواره: hitting the game wall");
                break;
            case 1: // راست
                if (xCol + 1 < k + 1) xCol++;
                else System.out.println("برخورد با دیواره: hitting the game wall");
                break;
            case 2: // پایین
                if (xRow + 1 < k + 1) xRow++;
                else System.out.println("برخورد با دیواره: hitting the game wall");
                break;
            case 3: // چپ
                if (xCol - 1 > 0) xCol--;
                else System.out.println("برخورد با دیواره: hitting the game wall");
                break;
            default:
                System.out.println("دستور نامعتبر!");
        }

        if (array[xRow][xCol] == '.') {
            score++;
        }

        array[xRow][xCol] = 'X';
    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile))) {
            writer.write(k + "\n");
            writer.write(c + "\n");
            writer.write(xRow + "\n");
            writer.write(xCol + "\n");
            writer.write(score + "\n");

            for (int i = 0; i < k + 2; i++) {
                writer.write(new String(array[i]) + "\n");
            }
        } catch (IOException e) {
            System.out.println("خطا در ذخیره بازی.");
        }
    }

    private void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(saveFile))) {
            k = Integer.parseInt(reader.readLine());
            c = Integer.parseInt(reader.readLine());
            xRow = Integer.parseInt(reader.readLine());
            xCol = Integer.parseInt(reader.readLine());
            score = Integer.parseInt(reader.readLine());

            array = new char[k + 2][k + 2];
            for (int i = 0; i < k + 2; i++) {
                array[i] = reader.readLine().toCharArray();
            }
            System.out.println("بازی از فایل ذخیره بارگذاری شد.");
        } catch (IOException e) {
            System.out.println("خطا در بارگذاری فایل ذخیره.");
            initializeGame();
        }
    }
}
