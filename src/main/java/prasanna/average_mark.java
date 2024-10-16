
package prasanna;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/average_mark")
public class average_mark extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prasanna", "root", "root");

            String query = "select student_name, " +
                           "(english + tamil + maths + science + social) / 5.0 as average_mark " +
                           "from student_details";

            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            List<StudentAverage> averages = new ArrayList<>();
            while (rs.next()) {
                String student_name = rs.getString("student_name");
                double average_mark = rs.getDouble("average_mark");
                averages.add(new StudentAverage(student_name, average_mark));
            }

            req.setAttribute("averages", averages);
            req.getRequestDispatcher("average_mark.jsp").forward(req, resp);

        } 
        
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            resp.getWriter().write("Error: " + e.getMessage());
        } 
        
        finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } 
            catch (SQLException e) {
                e.printStackTrace();
                resp.getWriter().write("Error: " + e.getMessage());
            }
        }
    }
}
