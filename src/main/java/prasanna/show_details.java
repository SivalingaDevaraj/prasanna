package prasanna;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/show_details")
public class show_details extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<details> DetailsRef =new ArrayList<>();
		
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prasanna","root","root");
			String query = "select * from student_details order by roll_no asc";
			stmt =con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				
				String name = rs.getString("student_name");
				int roll= rs.getInt("roll_no");
				int english=rs.getInt("english");
				int tamil=rs.getInt("tamil");
				int maths=rs.getInt("maths");
				int science=rs.getInt("science");
				int social=rs.getInt("social");
		
				DetailsRef.add(new details(name,roll,english,tamil,maths,science,social));
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getWriter().write("Error :"+e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
		    if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
		    if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		    if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
		req.setAttribute("student_details", DetailsRef);
	
		RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
	
		dispatcher.forward(req, resp);
	}
	
	
	
}
