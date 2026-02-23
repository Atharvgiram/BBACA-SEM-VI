import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class S23b extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "Atharv",
                "123"   // replace with your password
            );

            String sql = "SELECT * FROM LOGIN_INFO WHERE USERNAME=? AND PASSWORD=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, uname);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            out.println("<html><body>");

            if (rs.next()) {
                out.println("<h2>Login Successful!</h2>");
            } else {
                out.println("<h2>Invalid Username or Password</h2>");
            }

            out.println("</body></html>");

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            out.println(e);
        }
    }
}
