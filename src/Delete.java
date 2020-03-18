import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4358616397573965123L;

	/**
	 * 
	 */
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String id = req.getParameter("id");

		try {
			// load Driver class
			Class.forName("com.mysql.jdbc.Driver");
			// create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/country", "root", "");
			// create statement
			Statement stmt = con.createStatement();
			String sql = "delete from country where Id=" + id;
			int i = stmt.executeUpdate(sql);
			if (i > 0) {
				res.sendRedirect("info");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
