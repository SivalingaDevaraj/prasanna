package prasanna;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete_student")
public class delete_student extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement stmt = null;

        try {

        	Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prasanna", "root", "root");
            
            String name = req.getParameter("name");
            String roll_no = req.getParameter("roll_no");
            
            String query = "delete from student_details where student_name = ? and roll_no = ?";
            stmt = con.prepareStatement(query);
            
            stmt.setString(1, name);
            stmt.setString(2, roll_no);
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                req.setAttribute("message", "Student deleted successfully.");
            } 
            
            else {
                req.setAttribute("message", "No student found with the given name and roll number.");
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
                resp.getWriter().write("Error: " + e.getMessage());
            }
        }
    }
}