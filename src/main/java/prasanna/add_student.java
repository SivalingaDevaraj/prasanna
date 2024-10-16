package prasanna;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add_student")
public class add_student extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("student_name");
        int rollNo;
        int english, tamil, maths, science, social;

        try {
            rollNo = Integer.parseInt(req.getParameter("roll_no"));
            english = Integer.parseInt(req.getParameter("english"));
            tamil = Integer.parseInt(req.getParameter("tamil"));
            maths = Integer.parseInt(req.getParameter("maths"));
            science = Integer.parseInt(req.getParameter("science"));
            social = Integer.parseInt(req.getParameter("social"));
        } catch (NumberFormatException e) {
            resp.getWriter().write("Invalid input: " + e.getMessage());
            return;
        }

        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prasanna", "root", "root");

            String query = "insert into student_details (student_name, roll_no, english, tamil, maths, science, social) values (?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(query);

            stmt.setString(1, name);
            stmt.setInt(2, rollNo);
            stmt.setInt(3, english);
            stmt.setInt(4, tamil);
            stmt.setInt(5, maths);
            stmt.setInt(6, science);
            stmt.setInt(7, social);

            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                req.setAttribute("message", " New Student Details Added Successfully.");
            } 
            
            else {
                req.setAttribute("message", " Failed to add Details!.");
            }
            
            req.getRequestDispatcher("result.jsp").forward(req, resp);

            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            resp.getWriter().write("Error: " + e.getMessage());
        } 
        
        finally {
            
        	try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } 
            
            catch (SQLException e) {
                e.printStackTrace();
                resp.getWriter().write("Error closing resources: " + e.getMessage());
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}