package Int.ComperableAndComperator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Student otherStudent) {
        // Compare students based on their age
        return Integer.compare(this.age, otherStudent.age);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + '}';
    }
}

public class Main1 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 22));
        students.add(new Student("Charlie", 18));

        // Before sorting
        System.out.println("Before sorting:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sorting the students based on age using Collections.sort() method
        Collections.sort(students);

        // After sorting
        System.out.println("\nAfter sorting based on age:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
