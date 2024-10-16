package prasanna;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/adminlogin")
public class adminlogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			Connection con=null;
			PreparedStatement stmt=null;
			ResultSet rs=null; 
			
		try {
			
			String admin_name = req.getParameter("admin_name");
			String password = req.getParameter("password");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prasanna","root","root");
			
			String query ="SELECT admin_name, password FROM admin_login where admin_name = ? AND password = ?";
			
			stmt= con.prepareStatement(query);
			
			 stmt.setString(1, admin_name);
	         stmt.setString(2, password);
			
			rs = stmt.executeQuery();

            if (rs.next()) {
                
                RequestDispatcher dispatcher = req.getRequestDispatcher("admin_access.jsp");
                dispatcher.forward(req, resp);
                
            } else {
                
                req.setAttribute("message", "Invalid admin name or password.");
                
                req.getRequestDispatcher("result.jsp").forward(req, resp);
                
            }
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getWriter().write("Error :"+e.getMessage());
			
		}
		
		finally {
		    if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
		    if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		    if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
		
		
		
	}
	
	
}
