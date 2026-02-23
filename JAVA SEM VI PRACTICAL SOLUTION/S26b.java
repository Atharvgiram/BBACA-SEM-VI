import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class S26b extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String hobby = request.getParameter("hobby");

        if(hobby != null) {

            boolean found = false;
            Cookie[] cookies = request.getCookies();

            if(cookies != null) {
                for(Cookie c : cookies) {
                    if(c.getName().equals("hobby") &&
                       c.getValue().equals(hobby)) {
                        found = true;
                    }
                }
            }

            if(!found) {
                Cookie ck = new Cookie("hobby", hobby);
                response.addCookie(ck);
            }
        }

        out.println("<html><body>");
        out.println("<h2>Select Your Hobby</h2>");
        out.println("<form method='get'>");

        out.println("<input type='radio' name='hobby' value='Painting'>Painting<br>");
        out.println("<input type='radio' name='hobby' value='Drawing'>Drawing<br>");
        out.println("<input type='radio' name='hobby' value='Singing'>Singing<br>");
        out.println("<input type='radio' name='hobby' value='Swimming'>Swimming<br><br>");

        out.println("<input type='submit' value='Submit'>");
        out.println("<input type='reset' value='Reset'>");

        out.println("</form>");
        out.println("</body></html>");
    }
}
