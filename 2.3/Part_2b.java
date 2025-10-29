import java.io.*;

// Student class inside the same file
class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    int studentID;
    String name;
    double grade;

    public Student(int studentID, String name, double grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    public void display() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
    }
}

public class Part_2b {
    public static void main(String[] args) {
        String filename = "student.dat";

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            Student s1 = new Student(101, "Anirudh", 9.2);
            oos.writeObject(s1);
            System.out.println("✅ Student object serialized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Student s2 = (Student) ois.readObject();
            System.out.println("\n✅ Student object deserialized successfully!");
            s2.display();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
