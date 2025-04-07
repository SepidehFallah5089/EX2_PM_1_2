import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        return name + ", " + author + ", " + pages + " pages, " + year;
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
        return firstName + " " + lastName + ", " + studentNumber + ", " + field;
    }
}

// کلاس اصلی
public class EX3_LM_1_2_B {
    public static void main(String[] args) {
        // خواندن کتاب‌ها از فایل
        List<Book> books = readBooksFromFile("books.txt");
        System.out.println("Books:");
        for (Book book : books) {
            System.out.println(book);
        }

        // خواندن دانشجویان از فایل
        List<Student> students = readStudentsFromFile("students.txt");
        System.out.println("\nStudents:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // متد خواندن کتاب‌ها از فایل
    private static List<Book> readBooksFromFile(String fileName) {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0].trim();
                    String author = parts[1].trim();
                    int pages = Integer.parseInt(parts[2].trim());
                    int year = Integer.parseInt(parts[3].trim());
                    books.add(new Book(name, author, pages, year));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading books: " + e.getMessage());
        }
        return books;
    }

    // متد خواندن دانشجویان از فایل
    private static List<Student> readStudentsFromFile(String fileName) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String firstName = parts[0].trim();
                    String lastName = parts[1].trim();
                    String studentNumber = parts[2].trim();
                    String field = parts[3].trim();
                    students.add(new Student(firstName, lastName, studentNumber, field));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading students: " + e.getMessage());
        }
        return students;
    }
}

