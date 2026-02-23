<%@ page import="java.sql.*" %>
<html>
<head>
    <title>College Details</title>
</head>
<body>

<h2 align="center">College Details</h2>

<table border="1" align="center" cellpadding="5">
<tr>
    <th>College ID</th>
    <th>College Name</th>
    <th>Address</th>
</tr>

<%
Connection con = null;
Statement stmt = null;
ResultSet rs = null;

try {
    Class.forName("oracle.jdbc.driver.OracleDriver");

    con = DriverManager.getConnection(
        "jdbc:oracle:thin:@localhost:1521:XE",
        "Atharv",
        "123"  // replace with your password
    );

    stmt = con.createStatement();
    rs = stmt.executeQuery("SELECT * FROM COLLEGE");

    while(rs.next()) {
%>

<tr>
    <td><%= rs.getInt("CollegeID") %></td>
    <td><%= rs.getString("Coll_Name") %></td>
    <td><%= rs.getString("Address") %></td>
</tr>

<%
    }
} catch(Exception e) {
    out.println(e);
} finally {
    if(rs!=null) rs.close();
    if(stmt!=null) stmt.close();
    if(con!=null) con.close();
}
%>

</table>

</body>
</html>
