package paytm2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Registration")
public class Registration extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		PrintWriter p=res.getWriter();
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String ps1=req.getParameter("password");
		String ps2=req.getParameter("cpassword");
		String salt = PasswordHashUtility.generateSalt();
		String password=PasswordHashUtility.hashPassword(ps1,salt);
		String cPassword=PasswordHashUtility.hashPassword(ps2,salt);
		
		
		if(password.equals(cPassword)) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advJava","root","8688744624");
				PreparedStatement pr=con.prepareStatement("Insert into users(name,email,password,cpassword) values(?,?,?,?)");
				pr.setString(1,name);
				pr.setString(2,email);
				pr.setString(3,password);
				pr.setString(4,cPassword);
				int i=pr.executeUpdate();
				if(i>=0) {
					RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
					rd.forward(req, res);
				}else {
					p.println("Failed");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			p.println("Password not matched with confirm password");
		}
				
	}
}
