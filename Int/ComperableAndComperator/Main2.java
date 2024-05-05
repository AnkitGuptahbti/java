package Int.ComperableAndComperator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student2 {
    private String name;
    private int age;

    public Student2(String name, int age) {
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
    public String toString() {
        return "Student2{name='" + name + "', age=" + age + '}';
    }
}

class AgeComparator implements Comparator<Student2> {
    @Override
    public int compare(Student2 s1, Student2 s2) {
        // Compare Student2s based on their age
        return Integer.compare(s1.getAge(), s2.getAge());
    }
}

public class Main2 {
    public static void main(String[] args) {
        List<Student2> Student2s = new ArrayList<>();
        Student2s.add(new Student2("Alice", 20));
        Student2s.add(new Student2("Bob", 22));
        Student2s.add(new Student2("Charlie", 18));

        // Before sorting
        System.out.println("Before sorting:");
        for (Student2 Student2 : Student2s) {
            System.out.println(Student2);
        }

        // Sorting the Student2s based on age using a custom comparator
        Collections.sort(Student2s, new AgeComparator());

        // After sorting
        System.out.println("\nAfter sorting based on age:");
        for (Student2 Student2 : Student2s) {
            System.out.println(Student2);
        }
    }
}
