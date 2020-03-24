/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.filters;

import java.io.IOException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.util.HtmlUtils;

/**
 *
 * @author aelinadas
 */
public class MovieFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Enumeration params = httpServletRequest.getParameterNames();
        String input = "";
        while (params.hasMoreElements()) {
            String name = params.nextElement().toString();
            String[] value = httpServletRequest.getParameterValues(name);
            for (int i = 0; i < value.length; i++) {
                input += value[i];
            }
        }
        String sqlInjectStrList = "‘|or|and|;|-|--|+|,|like|//|/|*|%|#";
        if (sqlValidate(input, sqlInjectStrList) || isHtml(input)) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.getWriter().write("Invalid Input Data");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected static boolean sqlValidate(String str, String sqlInjectStrList) {
        str = str.toLowerCase();
        String[] badStrs = sqlInjectStrList.split("\\|");
        for (int i = 0; i < badStrs.length; i++) {
            if (isContain(str, badStrs[i])) {
                return true;
            }
        }
        return false;
    }
    protected static boolean isHtml(String input) {
        boolean isHtml = false;
        if (input != null) {
            if (!input.equals(HtmlUtils.htmlEscape(input))) {
                isHtml = true;
            }
        }
        return isHtml;
    }
    private static boolean isContain(String source, String subItem) {
        String pattern = "\\b" + Pattern.quote(subItem) + "\\b";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);
        return m.find();
    }
    
}
