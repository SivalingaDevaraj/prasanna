package prasanna;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/highest_mark")
public class highest_mark extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prasanna", "root", "root");

            String query = "select max(english) as max_english, max(tamil) as max_tamil, " +
                           "max(maths) as max_maths, max(science) as max_science, max(social) as max_social " +
                           "from student_details";

            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            if (rs.next()) {
                req.setAttribute("maxEnglish", rs.getInt("max_english"));
                req.setAttribute("maxTamil", rs.getInt("max_tamil"));
                req.setAttribute("maxMaths", rs.getInt("max_maths"));
                req.setAttribute("maxScience", rs.getInt("max_science"));
                req.setAttribute("maxSocial", rs.getInt("max_social"));
            }

            req.getRequestDispatcher("highest_mark.jsp").forward(req, resp);

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