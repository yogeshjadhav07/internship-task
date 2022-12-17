import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public Register() {
       
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		
		String pass = req.getParameter("loginPassword");
		String pass1 = req.getParameter("ConfirmPassword");
//		boolean t=false;

		if(pass.length()<8) {
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Password must have atleast 8 characters ');");  
			out.println("window.location.assign('register.html');");  
			out.println("</script>");
			
		}
		else {
		if(pass.equals(pass1))
		{
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3389/eternalight","root","4144");
				
					if(con==null)
					{
						out.println("Connection Failed");
					}
					
					
					PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?)");
								
					ps.setString(1, email);
		              ps.setString(2, name);
		             ps.setString(3, pass);
		             
		              int i = ps.executeUpdate();
		              if(i>0)
		              {
		          		out.println("<script type=\"text/javascript\">");  
		    			out.println("alert('Registration Successful');");  
		    			out.println("window.location.assign('index.html');");  
		    			out.println("</script>");
		              }
		              else
		              {
		            	  out.println("Data not inserted");
		              }
		           
		              
		              
		              out.close();
			
				} catch(Exception e) {
					System.out.println(e);
				}
		}
		
		else
		{
			
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Password Does not match!');");  
			out.println("window.location.assign('register.html');");  
			out.println("</script>");
	            

	}
		}
	}

}