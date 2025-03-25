import java.util.Scanner;

public class EX2_PM_1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of k:");
        int k = scanner.nextInt();

        // ایجاد آرایه دو‌بعدی با سایز k+2
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

        // چاپ آرایه
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
