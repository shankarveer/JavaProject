package paytm2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;
@WebServlet("/Login")
public class Login extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		PrintWriter p=res.getWriter();
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advJava","root","8688744624");
			PreparedStatement pr=con.prepareStatement("select password from users where email=?");
			pr.setString(1,email);
			
			ResultSet r=pr.executeQuery();
			if(r.next()) {
				String dbpassword=r.getString("password");
				 if (PasswordHashUtility.verifyPassword(password, dbpassword)) {
					 RequestDispatcher rd=req.getRequestDispatcher("landingpage.jsp");
						rd.forward(req, res);
				 }
			}else {
				p.println("Login not  Successful!");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
