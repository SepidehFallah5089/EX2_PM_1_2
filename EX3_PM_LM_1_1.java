// کلاس Book
class Book {
    private String name;
    private String author;
    private int pages;
    private int year;

    // سازنده
    public Book(String name, String author, int pages, int year) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.year = year;
    }

    // متدهای دریافت و تنظیم
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

// کلاس Student
class Student {
    private String firstName;
    private String lastName;
    private String studentNumber;
    private String field;

    // سازنده
    public Student(String firstName, String lastName, String studentNumber, String field) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.field = field;
    }

    // متدهای دریافت و تنظیم
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}

// کلاس اصلی
public class EX3_PM_LM_1_1 {
    public static void main(String[] args) {
        // ایجاد نمونه‌های کتاب
        Book book1 = new Book("Programming Basics", "John Doe", 300, 2020);
        Book book2 = new Book("Advanced Java", "Jane Smith", 450, 2022);

        // ایجاد نمونه‌های دانشجو
        Student student1 = new Student("Ali", "Rezaei", "12345", "Computer Science");
        Student student2 = new Student("Sara", "Ahmadi", "67890", "Mathematics");

        // نمایش اطلاعات نمونه‌ها
        System.out.println("Book 1: " + book1.getName() + " by " + book1.getAuthor());
        System.out.println("Book 2: " + book2.getName() + " by " + book2.getAuthor());

        System.out.println("Student 1: " + student1.getFirstName() + " " + student1.getLastName());
        System.out.println("Student 2: " + student2.getFirstName() + " " + student2.getLastName());
    }
}

