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


@WebServlet("/studentlogin")
public class studentlogin extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    String studentName = req.getParameter("student_name");
	    int rollNo = Integer.parseInt(req.getParameter("roll_no"));

		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prasanna","root","root");
			
			String query="Select * from student_details where student_name =? and roll_no =?";
			
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1,studentName);
			stmt.setInt(2,rollNo);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				
			String name= rs.getString("student_name");
			int english=rs.getInt("english");
			int tamil=rs.getInt("tamil");
			int maths=rs.getInt("maths");
			int science=rs.getInt("science");
			int social=rs.getInt("social");
			int total=(english+tamil+maths+science+social);
					
			 	req.setAttribute("studentName",name);
	            req.setAttribute("english",english);
	            req.setAttribute("tamil",tamil);
	            req.setAttribute("maths",maths);
	            req.setAttribute("science",science);
	            req.setAttribute("social", social);
	            req.setAttribute("total",total);
			
	            RequestDispatcher dispatcher = req.getRequestDispatcher("student_details.jsp");
	            dispatcher.forward(req, resp);
	            
	        } 
		        
		} 
		 
		 catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getWriter().write("Error :"+e.getMessage());
		}
		
		
	}
	
	
}
