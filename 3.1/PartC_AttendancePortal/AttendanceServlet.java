import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("studentId");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        String url = "jdbc:mysql://localhost:3306/nimbus";
        String user = "root";
        String pass = "your_password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            String query = "INSERT INTO Attendance VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));
            ps.setString(2, date);
            ps.setString(3, status);

            int result = ps.executeUpdate();

            if (result > 0) {
                out.println("<h2>Attendance recorded successfully!</h2>");
            } else {
                out.println("<h3>Failed to record attendance.</h3>");
            }

            con.close();
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
