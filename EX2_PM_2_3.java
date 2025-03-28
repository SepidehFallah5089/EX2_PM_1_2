import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class EX2_PM_2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // فایل ذخیره بازی
        File saveFile = new File("game_save.txt");

        int k = 0, xRow = 1, xCol = 1, score = 0, c = 0;
        char[][] array = null;

        // بررسی وجود فایل ذخیره
        if (saveFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(saveFile))) {
                k = Integer.parseInt(reader.readLine());
                xRow = Integer.parseInt(reader.readLine());
                xCol = Integer.parseInt(reader.readLine());
                score = Integer.parseInt(reader.readLine());
                c = Integer.parseInt(reader.readLine());

                array = new char[k + 2][k + 2];
                for (int i = 0; i < k + 2; i++) {
                    String line = reader.readLine();
                    array[i] = line.toCharArray();
                }
                System.out.println("بازی از فایل ذخیره بارگذاری شد.");
            } catch (IOException e) {
                System.out.println("خطا در بارگذاری فایل ذخیره.");
                return;
            }
        } else {
            // شروع بازی از ابتدا
            System.out.print("لطفا مقدار k را وارد کنید: ");
            k = scanner.nextInt();

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

            int emptyCells = k * k;
            while (true) {
                System.out.print("لطفا مقدار c را وارد کنید: ");
                c = scanner.nextInt();

                if (c <= emptyCells) {
                    break;
                } else {
                    System.out.println("خطا: مقدار وارد شده بزرگتر از تعداد خانه‌های خالی آرایه است. لطفا دوباره امتحان کنید.");
                }
            }

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
        }

        long start = System.currentTimeMillis();

        while (score < c) {
            for (int i = 0; i < k + 2; i++) {
                for (int j = 0; j < k + 2; j++) {
                    System.out.print(array[i][j]);
                }
                System.out.println();
            }
            System.out.println();

            System.out.print("جهت حرکت (w: بالا, d: راست, s: پایین, a: چپ) یا (q: خروج): ");
            char direction = scanner.next().charAt(0);

            if (direction == 'q') {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile))) {
                    writer.write(k + "\n");
                    writer.write(xRow + "\n");
                    writer.write(xCol + "\n");
                    writer.write(score + "\n");
                    writer.write(c + "\n");

                    for (int i = 0; i < k + 2; i++) {
                        writer.write(new String(array[i]) + "\n");
                    }
                } catch (IOException e) {
                    System.out.println("خطا در ذخیره بازی.");
                }
                System.out.println("بازی ذخیره شد. خداحافظ!");
                break;
            }

            array[xRow][xCol] = ' ';

            switch (direction) {
                case 'w':
                    if (xRow - 1 > 0) xRow--;
                    else System.out.println("برخورد با دیواره: hitting the game wall");
                    break;
                case 'd':
                    if (xCol + 1 < k + 1) xCol++;
                    else System.out.println("برخورد با دیواره: hitting the game wall");
                    break;
                case 's':
                    if (xRow + 1 < k + 1) xRow++;
                    else System.out.println("برخورد با دیواره: hitting the game wall");
                    break;
                case 'a':
                    if (xCol - 1 > 0) xCol--;
                    else System.out.println("برخورد با دیواره: hitting the game wall");
                    break;
                default:
                    System.out.println("دستور نامعتبر!");
            }

            if (array[xRow][xCol] == '.') {
                score++;
                System.out.println("امتیاز: " + score);
            }

            array[xRow][xCol] = 'X';
        }

        if (score == c) {
            long finish = System.currentTimeMillis();
            long timeElapsed = finish - start;
            System.out.println("بازی تمام شد!");
            System.out.println("امتیاز نهایی: " + score);
            System.out.println("زمان سپری‌شده: " + timeElapsed + " میلی‌ثانیه");

            if (saveFile.exists()) {
                saveFile.delete();
            }
        }

        scanner.close();
    }
}
