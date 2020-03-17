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
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
/*		String country = req.getParameter("country");  */
		String country = req.getParameter("country");
		Information info=new Information();	
		info.setCountry(country);
		try {
			// load Driver class
			Class.forName("com.mysql.jdbc.Driver");
			// create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/country", "root", "");
			// create statement
			Statement stmt = con.createStatement();
			String sql = "insert into country (Country) values('" + info.getCountry() + "')";
		    stmt.executeUpdate(sql);
		   		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}