import java.io.*;
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
        return name + "," + author + "," + pages + "," + year;
    }

    public static Book fromString(String data) {
        String[] parts = data.split(",");
        if (parts.length == 4) {
            String name = parts[0].trim();
            String author = parts[1].trim();
            int pages = Integer.parseInt(parts[2].trim());
            int year = Integer.parseInt(parts[3].trim());
            return new Book(name, author, pages, year);
        }
        return null;
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

    public static Student fromString(String data) {
        String[] parts = data.split(",");
        if (parts.length == 4) {
            String firstName = parts[0].trim();
            String lastName = parts[1].trim();
            String studentNumber = parts[2].trim();
            String field = parts[3].trim();
            return new Student(firstName, lastName, studentNumber, field);
        }
        return null;
    }
}

// کلاس اصلی
public class EX3_LM_1_2_C {
    public static void main(String[] args) {
        // ایجاد نمونه‌ها و ذخیره اطلاعات در فایل‌ها
        Book[] books = {
            new Book("Programming Basics", "John Doe", 300, 2020),
            new Book("Advanced Java", "Jane Smith", 450, 2022),
            new Book("Data Structures", "Alice Brown", 350, 2019),
            new Book("Algorithms", "Bob White", 400, 2021)
        };

        Student[] students = {
            new Student("Ali", "Rezaei", "12345", "Computer Science"),
            new Student("Sara", "Ahmadi", "67890", "Mathematics"),
            new Student("Reza", "Kiani", "11223", "Physics")
        };

        saveBooksToFile(books, "books.txt");
        saveStudentsToFile(students, "students.txt");

        // خواندن اطلاعات از فایل‌ها
        List<Book> loadedBooks = readBooksFromFile("books.txt");
        List<Student> loadedStudents = readStudentsFromFile("students.txt");

        // نمایش اطلاعات خوانده‌شده
        System.out.println("Books:");
        for (Book book : loadedBooks) {
            System.out.println(book);
        }

        System.out.println("\nStudents:");
        for (Student student : loadedStudents) {
            System.out.println(student);
        }
    }

    // متد استاتیک برای ذخیره کتاب‌ها در فایل
    public static void saveBooksToFile(Book[] books, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Book book : books) {
                writer.write(book.toString() + "\n");
            }
            System.out.println("Books saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving books: " + e.getMessage());
        }
    }

    // متد استاتیک برای ذخیره دانشجویان در فایل
    public static void saveStudentsToFile(Student[] students, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Student student : students) {
                writer.write(student.toString() + "\n");
            }
            System.out.println("Students saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving students: " + e.getMessage());
        }
    }

    // متد استاتیک برای خواندن کتاب‌ها از فایل
    public static List<Book> readBooksFromFile(String fileName) {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Book book = Book.fromString(line);
                if (book != null) {
                    books.add(book);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading books: " + e.getMessage());
        }
        return books;
    }

    // متد استاتیک برای خواندن دانشجویان از فایل
    public static List<Student> readStudentsFromFile(String fileName) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Student student = Student.fromString(line);
                if (student != null) {
                    students.add(student);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading students: " + e.getMessage());
        }
        return students;
    }
}
