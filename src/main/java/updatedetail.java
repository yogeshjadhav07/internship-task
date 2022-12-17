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
import javax.servlet.http.HttpSession;


@WebServlet("/updatedetail")
public class updatedetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public updatedetail() {
       
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
	
		String name = req.getParameter("updatename");
		
		String pass = req.getParameter("updatepass");
	
		
		 HttpSession session=req.getSession(true);  
	        String email1=(String)session.getAttribute("a");  


		if(pass.length()<8) {
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Password must have atleast 8 characters ');");  
			out.println("window.location.assign('updatedetail');");  
			out.println("</script>");
			
		}
		else {
		
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3389/eternalight","root","4144");
				
				
					
					PreparedStatement ps = con.prepareStatement("update user set email=?,name=?,password=? where email='"+email1+"'");
								
					ps.setString(1, email1);
		              ps.setString(2, name);
		             ps.setString(3, pass);
		             
		              int i = ps.executeUpdate();
		              if(i>0)
		              {
		          		out.println("<script type=\"text/javascript\">");  
		    			out.println("alert('Data changed  Successfully');");  
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
	}

}



