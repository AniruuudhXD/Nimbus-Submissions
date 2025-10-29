import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class EmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String empId = request.getParameter("empId");

        String url = "jdbc:mysql://localhost:3306/nimbus";
        String user = "root";
        String pass = "your_password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            Statement st;
            if (empId != null && !empId.isEmpty()) {
                st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM Employee WHERE EmpID=" + empId);
                if (rs.next()) {
                    out.println("<h2>Employee Found:</h2>");
                    out.println("<p>ID: " + rs.getInt("EmpID") + "</p>");
                    out.println("<p>Name: " + rs.getString("Name") + "</p>");
                    out.println("<p>Salary: " + rs.getDouble("Salary") + "</p>");
                } else {
                    out.println("<h3>No employee found with ID " + empId + "</h3>");
                }
            } else {
                st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM Employee");
                out.println("<h2>All Employees:</h2><table border='1'><tr><th>ID</th><th>Name</th><th>Salary</th></tr>");
                while (rs.next()) {
                    out.println("<tr><td>" + rs.getInt("EmpID") + "</td><td>"
                            + rs.getString("Name") + "</td><td>"
                            + rs.getDouble("Salary") + "</td></tr>");
                }
                out.println("</table>");
            }
            con.close();
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}