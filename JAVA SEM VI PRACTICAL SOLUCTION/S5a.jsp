<html>
<body>

<form method="post">
    Enter Number: 
    <input type="text" name="num">
    <input type="submit" value="Calculate">
</form>

<%
    if(request.getParameter("num") != null) {

        int n = Integer.parseInt(request.getParameter("num"));
        int last = n % 10;

        int first = n;
        while(first >= 10) {
            first = first / 10;
        }

        int sum = first + last;
%>

<p style="color:red; font-size:18px;">
    Sum of First and Last Digit = <%= sum %>
</p>

<%
    }
%>

</body>
</html>
