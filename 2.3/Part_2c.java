import java.io.*;
import java.util.*;

class Employee {
    String name;
    int id;
    String designation;
    double salary;

    Employee(String name, int id, String designation, double salary) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + designation + "," + salary;
    }
}

public class Part_2c {
    private static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addEmployee(sc);
                case 2 -> displayEmployees();
                case 3 -> {
                    System.out.println("Exiting the application...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addEmployee(Scanner sc) {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Designation: ");
        String designation = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(name, id, designation, salary);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(emp.toString());
            bw.newLine();
            System.out.println("✅ Employee added successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayEmployees() {
        System.out.println("\n--- Employee Records ---");
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.printf("ID: %s | Name: %s | Designation: %s | Salary: %s%n",
                        data[0], data[1], data[2], data[3]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No employee records found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
