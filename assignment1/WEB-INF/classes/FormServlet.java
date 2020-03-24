import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

public class FormServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
			out.println("<!doctype HTML>");
        	out.println("<html>");
        	out.println("<head>");
        	out.println("<title>Form</title>");
        	out.println("</head>");
        	out.println("<body>");	
        	out.println("<h1>Form Details:</h1>");
        	out.println("Email: " + req.getParameter("email") + "<br/>");
            out.println("Password: " + req.getParameter("password") + "<br/>");
            out.println("Confirm Password: " + req.getParameter("confirm password") + "<br/>");
        	out.println("Image: " + req.getParameter("file") + "<br/>");
        	out.println("Gender: " + req.getParameter("gender") + "<br/>");
        	out.println("Country: " + req.getParameter("country") + "<br/>");
        	out.println("Hobby: " + Arrays.toString(req.getParameterValues("hobby")).substring(1,Arrays.toString(req.getParameterValues("hobby")).length()-1) + "<br/>");
        	out.println("Address: " + req.getParameter("address") + "<br/>");
        	out.println("</body>");
            out.println("</html>");
	}

}