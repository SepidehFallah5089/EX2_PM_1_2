import java.util.Scanner;

public class EX2_PM_2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

        // حلقه برای کنترل حرکت با کیبورد
        while (true) {
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

