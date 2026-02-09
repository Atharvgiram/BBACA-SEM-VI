import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class S6b extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int count = 0;
        boolean firstVisit = true;

        Cookie[] cookies = request.getCookies();

        if(cookies != null) {
            for(Cookie c : cookies) {
                if(c.getName().equals("visit")) {
                    count = Integer.parseInt(c.getValue());
                    count++;
                    firstVisit = false;
                }
            }
        }

        if(firstVisit) {
            out.println("<h2>Welcome! You are visiting for the first time.</h2>");
            count = 1;
        } else {
            out.println("<h2>You have visited this page " + count + " times.</h2>");
        }

        Cookie ck = new Cookie("visit", String.valueOf(count));
        ck.setMaxAge(60*60);   // valid for 1 hour
        response.addCookie(ck);

        out.close();
    }
}
