<%
    String username = request.getParameter("uname");
    String password = request.getParameter("pass");

    if(username != null && password != null && username.equals(password)) {
        response.sendRedirect("S16aSuccess.html");
    } else {
        response.sendRedirect("Error.html");
    }
%>
