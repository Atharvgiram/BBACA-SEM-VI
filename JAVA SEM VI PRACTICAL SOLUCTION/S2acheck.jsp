<%
String n = request.getParameter("num");

if (n != null) {

    int num = Integer.parseInt(n);
    int sum = 0;

    for (int i = 1; i < num; i++) {
        if (num % i == 0) {
            sum += i;
        }
    }

    if (sum == num) {
        out.println("<h4>" + num + " is Perfect Number</h4>");
    } else {
        out.println("<h4>" + num + " is Not Perfect Number</h4>");
    }
}
%>
