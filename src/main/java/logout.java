import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
@WebServlet("/logout")
public class logout extends HttpServlet {  
        protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                                throws ServletException, IOException {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
            out.println("<script type=\"text/javascript\">");  
			out.println("alert('Logged out Successfully');");  
			
			out.println("</script>");
            request.getRequestDispatcher("index.html").include(request, response);  
              
            HttpSession session=request.getSession();  
            session.invalidate();  
           
            out.print("You are successfully logged out!");  
              
            out.close();  
    }  
}  