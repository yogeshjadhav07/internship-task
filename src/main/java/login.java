import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public login() {
       
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String email = req.getParameter("email");
		
		
		   HttpSession session = req.getSession(true);
		session.setAttribute("a", email);

		
		Object id;
		int id1 = 0;
		String password = req.getParameter("loginPassword");
		
		boolean t=false;
	
	
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3389/eternalight","root","4144");
				
	Statement stmt = con.createStatement();
    ResultSet rs=stmt.executeQuery("select * from user where email='"+email+"'");
					
				

						rs.next();

						  String p=rs.getString("password");
						  if(password.equals(p))
						  {
						  out.println("<script type=\"text/javascript\">");  
			    			out.println("alert('Login Successful');");  
			    			out.println("window.location.assign('dashboard1');");  
			    			out.println("</script>");
							  
						 }
						  else
							{
							  out.println("<script type=\"text/javascript\">");  
				    			out.println("alert('Wrong Password. Please Enter Correct Password!');");  
				    			out.println("window.location.assign('login');");  
				    			out.println("</script>");
							 }
							
					
					
		              
		              out.close();
			
				} catch(Exception e) {
					System.out.println(e);
				}
		}
		
	
		
	

}