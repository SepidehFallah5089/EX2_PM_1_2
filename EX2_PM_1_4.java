import java.util.Scanner;

public class EX2_PM_1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a character: ");
            char input = scanner.next().charAt(0);

            switch (input) {
                case 'w':
                    System.out.println("UP");
                    break;
                case 'a':
                    System.out.println("LEFT");
                    break;
                case 's':
                    System.out.println("DOWN");
                    break;
                case 'd':
                    System.out.println("RIGHT");
                    break;
                case 'q':
                    System.out.println("EXIT");
                    scanner.close(); // بستن ورودی
                    return; // خروج از برنامه
                default:
                    System.out.println("WARNING");
                    break;
            }
        }
    }
}

