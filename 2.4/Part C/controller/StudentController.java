package controller;

import java.sql.*;
import java.util.*;
import model.Student;

public class StudentController {
    private Connection conn;

    public StudentController() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student s) {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO Student VALUES (?, ?, ?, ?)")) {
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getDepartment());
            ps.setDouble(4, s.getMarks());
            ps.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAllStudents() {
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM Student")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " +
                                   rs.getString(3) + " | " + rs.getDouble(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(int id, double newMarks) {
        try (PreparedStatement ps = conn.prepareStatement("UPDATE Student SET Marks=? WHERE StudentID=?")) {
            ps.setDouble(1, newMarks);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Student updated!" : "Student not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM Student WHERE StudentID=?")) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Student deleted!" : "Student not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}