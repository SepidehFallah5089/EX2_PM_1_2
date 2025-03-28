import java.util.Random;
import java.util.Scanner;

public class EX2_PM_1_5 {
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

        // قرار دادن کاراکتر X در گوشه سمت چپ بالا
        int xRow = 1;
        int xCol = 1;
        array[xRow][xCol] = 'X';

        // حلقه بینهایت برای حرکت تصادفی
        while (true) {
            // چاپ آرایه
            for (int i = 0; i < k + 2; i++) {
                for (int j = 0; j < k + 2; j++) {
                    System.out.print(array[i][j]);
                }
                System.out.println();
            }
            System.out.println();

            // ایجاد جهت حرکت تصادفی
            int direction = random.nextInt(4); // 0 بالا، 1 راست، 2 پایین، 3 چپ
            System.out.println("جهت حرکت: " + (direction == 0 ? "بالا" : direction == 1 ? "راست" : direction == 2 ? "پایین" : "چپ"));

            // حذف X از موقعیت فعلی
            array[xRow][xCol] = ' ';

            // بروزرسانی موقعیت براساس جهت
            switch (direction) {
                case 0: // بالا
                    if (xRow - 1 > 0) {
                        xRow--;
                    } else {
                        System.out.println("برخورد با دیواره: hitting the game wall");
                    }
                    break;
                case 1: // راست
                    if (xCol + 1 < k + 1) {
                        xCol++;
                    } else {
                        System.out.println("برخورد با دیواره: hitting the game wall");
                    }
                    break;
                case 2: // پایین
                    if (xRow + 1 < k + 1) {
                        xRow++;
                    } else {
                        System.out.println("برخورد با دیواره: hitting the game wall");
                    }
                    break;
                case 3: // چپ
                    if (xCol - 1 > 0) {
                        xCol--;
                    } else {
                        System.out.println("برخورد با دیواره: hitting the game wall");
                    }
                    break;
            }

            // قرار دادن X در موقعیت جدید
            array[xRow][xCol] = 'X';

            // تاخیر یک ثانیه‌ای
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
