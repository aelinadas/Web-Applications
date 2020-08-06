/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.interceptors;

import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.HtmlUtils;

/**
 *
 * @author aelinadas
 */
public class MovieInterceptor extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
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
            httpServletResponse.getWriter().write("Invalid Input Data");
            return false;
        }
        return true;
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
