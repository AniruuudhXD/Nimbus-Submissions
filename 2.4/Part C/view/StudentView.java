package view;

import controller.StudentController;
import model.Student;
import java.util.Scanner;

public class StudentView {
    public static void main(String[] args) {
        StudentController controller = new StudentController();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Student Management Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter ID: "); int id = sc.nextInt();
                    System.out.print("Enter Name: "); String name = sc.next();
                    System.out.print("Enter Department: "); String dept = sc.next();
                    System.out.print("Enter Marks: "); double marks = sc.nextDouble();
                    controller.addStudent(new Student(id, name, dept, marks));
                    break;
                case 2:
                    controller.viewAllStudents();
                    break;
                case 3:
                    System.out.print("Enter ID to update: "); int uid = sc.nextInt();
                    System.out.print("Enter new Marks: "); double newMarks = sc.nextDouble();
                    controller.updateStudent(uid, newMarks);
                    break;
                case 4:
                    System.out.print("Enter ID to delete: "); int did = sc.nextInt();
                    controller.deleteStudent(did);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}