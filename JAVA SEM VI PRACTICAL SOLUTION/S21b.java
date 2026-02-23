import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class S21b extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String seatno = request.getParameter("seatno");
        String name = request.getParameter("name");
        String studClass = request.getParameter("class");
        int marks = Integer.parseInt(request.getParameter("marks"));

        double percentage = marks / 5.0;  // assuming total marks out of 500

        String grade;

        if (percentage >= 75)
            grade = "Distinction";
        else if (percentage >= 60)
            grade = "First Class";
        else if (percentage >= 50)
            grade = "Second Class";
        else if (percentage >= 40)
            grade = "Pass";
        else
            grade = "Fail";

        out.println("<html><body>");
        out.println("<h2>Student Result</h2>");
        out.println("Seat No: " + seatno + "<br>");
        out.println("Name: " + name + "<br>");
        out.println("Class: " + studClass + "<br>");
        out.println("Total Marks: " + marks + "<br>");
        out.println("Percentage: " + percentage + "%<br>");
        out.println("Grade: " + grade + "<br>");
        out.println("</body></html>");
    }
}
