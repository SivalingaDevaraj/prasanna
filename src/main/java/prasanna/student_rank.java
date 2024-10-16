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


@WebServlet("/student_rank")
public class student_rank extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		List<Student> student = new ArrayList<>();
	
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prasanna","root","root");
			
            String query = "select student_name, roll_no, (english + tamil + maths + science + social) as total_mark " +
                    "from student_details order by total_mark desc";

            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            while(rs.next()) {
            	
            	String name = rs.getString("student_name");
                int rollno = rs.getInt("roll_no");
                int totalmark = rs.getInt("total_mark");
            	
                student.add(new Student(name,rollno,totalmark));
            	
            }
            
            req.setAttribute("ranked_students",student);
            
            req.getRequestDispatcher("students_rank.jsp").forward(req, resp);
		
		} 
		
		catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
                resp.getWriter().write("Error : " + e.getMessage());
            }
        }	
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	
}
