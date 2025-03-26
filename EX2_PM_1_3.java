import java.util.Random;
import java.util.Scanner;

public class EX2_PM_1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the value of k:");
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
            System.out.print("Enter the value of c:");
            c = scanner.nextInt();

            if (c <= emptyCells) {
                break;
            } else {
                System.out.println("Error: The entered value is greater than the number of empty cells in the array. Please try again.");
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

        // چاپ آرایه به صورت سطر به سطر
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

        scanner.close();
    }
}

