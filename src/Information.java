import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/info")
public class Information extends HttpServlet{
 /**
	 * 
	 */
	private static final long serialVersionUID = -3703822096344209018L;

public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
	 
	 try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/country", "root", "");
			Statement stmt = con.createStatement();
			String sql = "select * from country";
			ResultSet rs = stmt.executeQuery(sql);
			List<Country> countryList = new ArrayList<>();
			while (rs.next()) {
				Country country = new Country();
				country.setId(rs.getInt(1));
				country.setCountry(rs.getString(2));
				countryList.add(country);
			}
			req.setAttribute("countryList", countryList);
			req.getRequestDispatcher("information.jsp").forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
 }
}