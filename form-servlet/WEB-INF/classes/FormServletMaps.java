import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;

public class FormServletMaps extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		Map m=req.getParameterMap();
        Set s = m.entrySet();
        Iterator it = s.iterator();
			out.println("<!doctype HTML>");
        	out.println("<html>");
        	out.println("<head>");
        	out.println("<title>Form</title>");
        	out.println("</head>");
        	out.println("<body>");	
        	out.println("<h1>Form Details:</h1>");
        	while(it.hasNext()){
                Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)it.next();
                String key=entry.getKey();
                String[] value=entry.getValue();
                out.println(key + ": ");
                if(value.length>1){    
                    for (int i = 0; i < value.length; i++) {
                        out.println("<li>" + value[i].toString() + "</li>");
                    }
                }else
                    out.println(value[0].toString());
                    out.println("</br>");
            }
        	out.println("</body>");
            out.println("</html>");
	}
}