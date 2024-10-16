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

@WebServlet("/insertdetails")
public class insertdetails extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		int roll_number= Integer.parseInt(req.getParameter("roll"));
		String name =req.getParameter("user_name");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			resp.getWriter().write("Error :"+e1.getMessage());
		}
		
		try {

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");

			String query ="insert into students_login(name,roll_no)values(?,?)";
			
			PreparedStatement stmt= con.prepareStatement(query);
			
			stmt.setString(1, name);
			stmt.setInt(2, roll_number);
			
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
			resp.getWriter().write("Error :"+e.getMessage());
		}
		
		resp.getWriter().write("loged in successfully");
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.getWriter().write("this url does not support get method");
		
	}
	
	
}
