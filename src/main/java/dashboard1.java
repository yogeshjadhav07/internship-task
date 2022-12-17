
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

/**
 * Servlet implementation class List
 */
@WebServlet("/dashboard1")
public class dashboard1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private int hitCount; 
    public dashboard1() {
        super();
        hitCount = 0;
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		// increment hitCount 
	      hitCount++; 
	      
	      String email = request.getParameter("email");
	      
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3389/eternalight","root","4144");
			
			
			 HttpSession session=request.getSession(true);  
		        String email1=(String)session.getAttribute("a");  
		        
		
			
			
			PreparedStatement ps = con.prepareStatement("select * from user where email='"+email1+"'");
			ResultSet rs = ps.executeQuery();
			
			
		
		while (rs.next()) 
		      {
			out.println(
					"<html lang=\"en\" >\r\n"
					+ "  <head>\r\n"
					
					
				
					
					
					+ "  \r\n"
					+ "     <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "   </head>\r\n"
					+" <title>Your Information</title>\r\n"
					+"<style>@keyframes bgcolor {\r\n"
					+ "    0% {\r\n"
					+ "        background-color: #45a3e5\r\n"
					+ "    }\r\n"
					+ "\r\n"
					+ "    30% {\r\n"
					+ "        background-color: #66bf39\r\n"
					+ "    }\r\n"
					+ "\r\n"
					+ "    60% {\r\n"
					+ "        background-color: rgb(0, 251, 220)\r\n"
					+ "    }\r\n"
					+ "\r\n"
					+ "    90% {\r\n"
					+ "        background-color: #f35\r\n"
					+ "    }\r\n"
					+ "\r\n"
					+ "    100% {\r\n"
					+ "        background-color: #864cbf\r\n"
					+ "    }\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "body {\r\n"
					+ "    -webkit-animation: bgcolor 20s infinite;\r\n"
					+ "    animation: bgcolor 10s infinite;\r\n"
					+ "    -webkit-animation-direction: alternate;\r\n"
					+ "    animation-direction: alternate;\r\n"
					+ "}.submit-btn {\r\n"
					+ "\r\n"
					+ "  display: block;\r\n"
					+ "\r\n"
					
					+ "\r\n"
					+ "  border: none;\r\n"
					+ "\r\n"
					+ "  outline: none;\r\n"
					+ "\r\n"
					+ "  background: #ff652f;\r\n"
					+ "\r\n"
					+ "  font-size: 1rem;\r\n"
					+ "\r\n"
					+ "  text-transform: uppercase;\r\n"
					+ "\r\n"
					+ "  letter-spacing: 1px;\r\n"
					+ "\r\n"
					+ "  padding: 10px 20px;\r\n"
					+ "\r\n"
					+ "  border-radius: 5px;\r\n"
					+ "\r\n"
					+ "  cursor: pointer;\r\n"
					+ "\r\n"
					+ "}</style>"
					+ "<body >\r\n"
					);
			
					out.println("<br><br>");
					out.println("<h1 style=\"color:red; text-align:center; font-size:60px; \">Your Dashboard</h1>");
					out.println("<form action=\"logout\" >\r\n"
							+ " <button type=\"submit\" value=\"Logout\" class=\"submit-btn\">Logout</button>\r\n"
							+ " </form>");
					out.println("<table>");
					
					out.println("<tr>");
			
					out.println("<td> <h2>User Name</h2> </td>");
					
					out.println("<td><h2> Email Id</h2> </td>");
					
					out.println("<td> <h2>Password </h2></td>");
										out.println("</tr>");
										out.println("<tr>");
						out.println("<td>" + rs.getString(2) + "</td>");
						out.println("<td>" + rs.getString(1) + "</td>");
						
						out.println("<td>" + rs.getString(3) + "</td>");
											out.println("</tr>");
								out.println("</table><br><br>");
								
								
								
								out.println(" <center><form action=\"updatedetail\" class=\"form\">\r\n"
										+ "\r\n"
										
										+ "\r\n<br><hr>"
										+ "      <h2>Update Details</h2>\r\n"
										+ "\r\n"
										+ "      <div class=\"input-group\">\r\n"
										+ "\r\n"
										+"  <label for=\"updatename\">Name</label>\r\n");
										out.println("<td>"+"<input name=\"updatename\" value=" + rs.getString(2) + ">"+"</td>");
										
										out.print( "\r\n"
										+ "      </div>\r\n"
										+ "\r\n"
										+ "      <div class=\"input-group\">\r\n"
										+ "\r\n"
										+"  <label for=\"updatepass\">Password</label>\r\n");
										out.println("<td>"+"<input name=\"updatepass\" value=" + rs.getString(3) + ">"+"</td>");
										out.println("\r\n"
										
										+ "\r\n"
										+ "      </div>\r\n"
										+ "\r\n"
										+ "      <input type=\"submit\" value=\"Update Details\" class=\"submit-btn\">\r\n"
										+ "\r\n"
										+ "     \r\n"
										
										+ "   </form></center>");
								out.println("<br><hr>");
							
								
						
							
								
					out.println("</center></body>");
					      }
		      
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}