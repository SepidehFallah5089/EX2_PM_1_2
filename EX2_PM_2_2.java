import java.util.Random;
import java.util.Scanner;

public class EX2_PM_2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("لطفا مقدار k را وارد کنید: ");
        int k = scanner.nextInt();

        // ایجاد آرایه دو بعدی k+2 در k+2
        char[][] array = new char[k + 2][k + 2];

        // مقداردهی آرایه
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                if (i == 0 || i == k + 1 || j == 0 || j == k + 1) {
                    array[i][j] = '*';
                } else {
                    array[i][j] = ' ';
                }
            }
        }

        // دریافت مقدار c از ورودی
        int emptyCells = (k * k); // تعداد خانه‌های خالی در آرایه
        int c;

        while (true) {
            System.out.print("لطفا مقدار c را وارد کنید: ");
            c = scanner.nextInt();

            if (c <= emptyCells) {
                break;
            } else {
                System.out.println("خطا: مقدار وارد شده بزرگتر از تعداد خانه‌های خالی آرایه است. لطفا دوباره امتحان کنید.");
            }
        }

        // قرار دادن کاراکتر نقطه به صورت تصادفی در c خانه
        int count = 0;
        while (count < c) {
            int randomRow = random.nextInt(k) + 1; // سطر تصادفی بین 1 و k
            int randomCol = random.nextInt(k) + 1; // ستون تصادفی بین 1 و k

            if (array[randomRow][randomCol] == ' ') {
                array[randomRow][randomCol] = '.';
                count++;
            }
        }

        // قرار دادن کاراکتر X در گوشه سمت چپ بالا
        int xRow = 1;
        int xCol = 1;
        array[xRow][xCol] = 'X';

        // شروع زمان اجرا
        long start = System.currentTimeMillis();

        // امتیاز نقطه‌خوار
        int score = 0;

        // حلقه برای کنترل حرکت نقطه‌خوار
        while (score < c) {
            // چاپ آرایه
            for (int i = 0; i < k + 2; i++) {
                for (int j = 0; j < k + 2; j++) {
                    System.out.print(array[i][j]);
                }
                System.out.println();
            }
            System.out.println();

            // درخواست جهت حرکت از کاربر
            System.out.print("جهت حرکت (w: بالا, d: راست, s: پایین, a: چپ): ");
            char direction = scanner.next().charAt(0);

            // حذف X از موقعیت فعلی
            array[xRow][xCol] = ' ';

            // بروزرسانی موقعیت براساس جهت
            switch (direction) {
                case 'w': // بالا
                    if (xRow - 1 > 0) {
                        xRow--;
                    } else {
                        System.out.println("برخورد با دیواره: hitting the game wall");
                    }
                    break;
                case 'd': // راست
                    if (xCol + 1 < k + 1) {
                        xCol++;
                    } else {
                        System.out.println("برخورد با دیواره: hitting the game wall");
                    }
                    break;
                case 's': // پایین
                    if (xRow + 1 < k + 1) {
                        xRow++;
                    } else {
                        System.out.println("برخورد با دیواره: hitting the game wall");
                    }
                    break;
                case 'a': // چپ
                    if (xCol - 1 > 0) {
                        xCol--;
                    } else {
                        System.out.println("برخورد با دیواره: hitting the game wall");
                    }
                    break;
                default:
                    System.out.println("دستور نامعتبر! لطفا فقط از w، d، s، یا a استفاده کنید.");
            }

            // بررسی نقطه‌خوردن
            if (array[xRow][xCol] == '.') {
                score++;
                System.out.println("امتیاز: " + score);
            }

            // قرار دادن X در موقعیت جدید
            array[xRow][xCol] = 'X';
        }

        // پایان زمان اجرا
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        // چاپ نتیجه بازی
        System.out.println("بازی تمام شد!");
        System.out.println("امتیاز نهایی: " + score);
        System.out.println("زمان سپری‌شده: " + timeElapsed + " میلی‌ثانیه");

        scanner.close();
    }
}
