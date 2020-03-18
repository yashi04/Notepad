import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/edit")
public class Edit extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
			String sql = "select * from country where Id=" + id;
			ResultSet rs = stmt.executeQuery(sql);
			Country country = new Country();
			while (rs.next()) {
				country.setId(rs.getInt(1));
				country.setCountry(rs.getString(2));
			}
			req.setAttribute("country", country);
			req.getRequestDispatcher("edit.jsp").forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}