<html>
<body>

<h2>Enter a Number</h2>

<form method="post">
    <input type="text" name="num">
    <input type="submit" value="Convert">
</form>

<%
    String num = request.getParameter("num");

    if(num != null) {

        String result = "";

        for(int i = 0; i < num.length(); i++) {

            char ch = num.charAt(i);

            switch(ch) {
                case '0': result += "Zero "; break;
                case '1': result += "One "; break;
                case '2': result += "Two "; break;
                case '3': result += "Three "; break;
                case '4': result += "Four "; break;
                case '5': result += "Five "; break;
                case '6': result += "Six "; break;
                case '7': result += "Seven "; break;
                case '8': result += "Eight "; break;
                case '9': result += "Nine "; break;
            }
        }
%>

<h3 style="color:red;">
    <%= result %>
</h3>

<%
    }
%>

</body>
</html>
