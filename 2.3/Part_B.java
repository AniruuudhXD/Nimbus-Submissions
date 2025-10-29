import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " - " + marks;
    }
}

public class Part_B {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("John", 80),
            new Student("Jane", 70),
            new Student("Mike", 85),
            new Student("Sara", 90)
        );

        // Filter students with marks > 75, sort by marks ascending, display names
        students.stream()
                .filter(s -> s.marks > 75)
                .sorted(Comparator.comparingDouble(s -> s.marks))
                .map(s -> s.name)
                .forEach(System.out::println);
    }
}
