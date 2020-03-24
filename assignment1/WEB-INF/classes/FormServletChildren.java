import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;

public class FormServletChildren extends HttpServlet  { 
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>YChildren name</title>");
        out.println("<body>");
        out.println("<h1>Your childrens' names are:</h1>");
        out.println(req.getParameter("child1"));
        out.println("<br>");
        out.println(req.getParameter("child2"));
        out.println("<br>");
        out.println(req.getParameter("child3"));
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
