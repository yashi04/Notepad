import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/country")
public class Insert extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3301894632450879289L;

	/**
	 * 
	 */
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		/* String country = req.getParameter("country"); */
		String country = req.getParameter("country");
		Country coun = new Country();
		coun.setCountry(country);
		try {
			// load Driver class
			Class.forName("com.mysql.jdbc.Driver");
			// create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/country", "root", "");
			// create statement
			Statement stmt = con.createStatement();
			String sql = "insert into country (Country) values('" + coun.getCountry() + "')";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		res.sendRedirect("index.html");

	}

}