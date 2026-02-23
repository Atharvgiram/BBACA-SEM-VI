<%@ page import="java.util.*" %>
<html>
<body>

<h2>Enter User Name</h2>

<form method="post">
    Name: <input type="text" name="uname">
    <input type="submit" value="Submit">
</form>

<%
    String name = request.getParameter("uname");

    if(name != null) {

        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);

        String msg = "";

        if(hour < 12)
            msg = "Good Morning";
        else if(hour < 18)
            msg = "Good Afternoon";
        else
            msg = "Good Evening";
%>

<h3><%= msg %>, <%= name %>!</h3>

<%
    }
%>

</body>
</html>
