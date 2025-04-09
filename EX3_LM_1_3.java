import java.util.ArrayList;
import java.util.List;

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

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + studentNumber + ", " + field;
    }
}

// کلاس اصلی
public class EX3_LM_1_3 {
    public static void main(String[] args) {
        // ایجاد آرایه‌ای از دانشجویان
        Student[] students = {
            new Student("Ali", "Rezaei", "12345", "Computer Science"),
            new Student("Sara", "Ahmadi", "67890", "Mathematics"),
            new Student("Reza", "Kiani", "11223", "Physics"),
            new Student("Narges", "Karimi", "44556", "Biology")
        };

        // جستجوی نام دانشجو
        String searchName = "Ali";
        List<Student> foundStudents = searchStudentsByName(students, searchName);

        // نمایش نتایج
        if (!foundStudents.isEmpty()) {
            System.out.println("Found Students:");
            for (Student student : foundStudents) {
                System.out.println(student);
            }
        } else {
            System.out.println("No students found with the name: " + searchName);
        }
    }

    // متد استاتیک برای جستجوی نام دانشجو
    public static List<Student> searchStudentsByName(Student[] students, String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getFirstName().equalsIgnoreCase(name)) {
                result.add(student);
            }
        }
        return result;
    }
}

