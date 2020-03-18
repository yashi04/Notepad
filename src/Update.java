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

@WebServlet("/update")
public class Update extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4709252279621713813L;

	/**
	 * 
	 */

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		String id = req.getParameter("id");
		String country = req.getParameter("country");
		try {
			// load Driver class
			Class.forName("com.mysql.jdbc.Driver");
			// create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/country", "root", "");
			// create statement
			Statement stmt = con.createStatement();
			String sql = "update country set Country='" + country + "' where Id=" + id;

			stmt.executeUpdate(sql);

			res.sendRedirect("info");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
