import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

public class FormServletParam extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        try {
            res.setContentType("text/html");
            Enumeration paramNames = req.getParameterNames();
            PrintWriter out = res.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User Details(Using Parameter Names)</title>");
            out.println("<body>");
            out.println("<h1>User Details</h1>");
            while (paramNames.hasMoreElements()) {
                String paramName = (String) paramNames.nextElement();
                if (paramName.equalsIgnoreCase("Email")) {
                    out.println("Email Id: " + req.getParameter(paramName));
                    out.println("<br>");
                }
                if (paramName.equalsIgnoreCase("Image")) {
                    out.println("Image: " + req.getParameter(paramName));
                    out.println("<br>");
                }
                if (paramName.equalsIgnoreCase("Password")) {
                    out.println("Password: " + req.getParameter(paramName));
                    out.println("<br>");
                }
                if (paramName.equalsIgnoreCase("Confirmpassword")) {
                    out.println("Confirm Password: " + req.getParameter(paramName));
                    out.println("<br>");
                }               
                if (paramName.equalsIgnoreCase("Gender")) {
                    out.println("Gender: " + req.getParameter(paramName));
                    out.println("<br>");
                }
                if (paramName.equalsIgnoreCase("Country")) {
                    out.println("Country: " + req.getParameter(paramName));
                    out.println("<br>");
                }
                if (paramName.equalsIgnoreCase("Hobby")) {
                    out.println("Hobbies: " + Arrays.toString(req.getParameterValues(paramName)).substring(1, Arrays.toString(req.getParameterValues(paramName)).length()-1));
                    out.println("<br>");
                }
                if (paramName.equalsIgnoreCase("Address")) {
                    out.println("Address: " + req.getParameter(paramName));
                    out.println("<br>");
                }
            }
            out.println("</body>");
            out.println("</html>");
            out.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }	
}