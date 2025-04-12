 import java.io.*;
import java.util.ArrayList;
import java.util.List;

// کلاس Loan (امانت)
class Loan {
    private String studentName;
    private String bookName;
    private String loanDate;

    public Loan(String studentName, String bookName, String loanDate) {
        this.studentName = studentName;
        this.bookName = bookName;
        this.loanDate = loanDate;
    }

    @Override
    public String toString() {
        return studentName + "," + bookName + "," + loanDate;
    }

    public static Loan fromString(String data) {
        String[] parts = data.split(",");
        if (parts.length == 3) {
            String studentName = parts[0].trim();
            String bookName = parts[1].trim();
            String loanDate = parts[2].trim();
            return new Loan(studentName, bookName, loanDate);
        }
        return null;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getBookName() {
        return bookName;
    }

    public String getLoanDate() {
        return loanDate;
    }
}

// کلاس اصلی
public class EX3_LM_1_4 {
    public static void main(String[] args) {
        // ایجاد داده‌های نمونه
        Loan[] loans = {
            new Loan("Ali Rezaei", "Programming Basics", "2025-04-01"),
            new Loan("Sara Ahmadi", "Advanced Java", "2025-04-03"),
            new Loan("Reza Kiani", "Data Structures", "2025-04-05")
        };

        // ذخیره اطلاعات امانت در فایل
        saveLoansToFile(loans, "loans.txt");

        // خواندن اطلاعات امانت از فایل
        List<Loan> loadedLoans = readLoansFromFile("loans.txt");

        // نمایش اطلاعات خوانده‌شده
        System.out.println("Loans:");
        for (Loan loan : loadedLoans) {
            System.out.println("Student: " + loan.getStudentName() + ", Book: " + loan.getBookName() + ", Date: " + loan.getLoanDate());
        }
    }

    // متد استاتیک برای ذخیره امانت‌ها در فایل
    public static void saveLoansToFile(Loan[] loans, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Loan loan : loans) {
                writer.write(loan.toString() + "\n");
            }
            System.out.println("Loans saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving loans: " + e.getMessage());
        }
    }

    // متد استاتیک برای خواندن امانت‌ها از فایل
    public static List<Loan> readLoansFromFile(String fileName) {
        List<Loan> loans = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Loan loan = Loan.fromString(line);
                if (loan != null) {
                    loans.add(loan);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading loans: " + e.getMessage());
        }
        return loans;
    }
}
