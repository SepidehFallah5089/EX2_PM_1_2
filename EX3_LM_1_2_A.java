import java.io.FileWriter;
import java.io.IOException;

// کلاس Book
class Book {
    private String name;
    private String author;
    private int pages;
    private int year;

    public Book(String name, String author, int pages, int year) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.year = year;
    }

    @Override
    public String toString() {
        return name + "," + author + "," + pages + "," + year;
    }
}

// کلاس Student
class Student {
    private String firstName;
    private String lastName;
    private String studentNumber;
    private String field;

    public Student(String firstName, String lastName, String studentNumber, String field) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.field = field;
    }

    @Override
    public String toString() {
        return firstName + "," + lastName + "," + studentNumber + "," + field;
    }
}

// کلاس اصلی
public class EX3_LM_1_2_A {
    public static void main(String[] args) {
        // ایجاد آرایه کتاب‌ها
        Book[] books = new Book[4];
        books[0] = new Book("Programming Basics", "John Doe", 300, 2020);
        books[1] = new Book("Advanced Java", "Jane Smith", 450, 2022);
        books[2] = new Book("Data Structures", "Alice Brown", 350, 2019);
        books[3] = new Book("Algorithms", "Bob White", 400, 2021);

        // ایجاد آرایه دانشجویان
        Student[] students = new Student[3];
        students[0] = new Student("Ali", "Rezaei", "12345", "Computer Science");
        students[1] = new Student("Sara", "Ahmadi", "67890", "Mathematics");
        students[2] = new Student("Reza", "Kiani", "11223", "Physics");

        // ذخیره اطلاعات در فایل‌ها
        saveBooksToFile(books, "books.txt");
        saveStudentsToFile(students, "students.txt");
    }

    // متد برای ذخیره کتاب‌ها در فایل
    private static void saveBooksToFile(Book[] books, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Book book : books) {
                writer.write(book.toString() + "\n");
            }
            System.out.println("Books saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving books: " + e.getMessage());
        }
    }

    // متد برای ذخیره دانشجویان در فایل
    private static void saveStudentsToFile(Student[] students, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Student student : students) {
                writer.write(student.toString() + "\n");
            }
            System.out.println("Students saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving students: " + e.getMessage());
        }
    }
}
//استاد به دلیل این که من کد هام رو از طریق ویژوال استدیو کد ارسال میکنم به همین دلبل کلاس هام هم داخل یک صفحه کد ارسال کردم 