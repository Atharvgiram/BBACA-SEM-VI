<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Account Details</title>
</head>
<body>

<h2>Enter Account Details</h2>

<form method="post">
    Account No: <input type="text" name="ano"><br><br>
    Type: <input type="text" name="type"><br><br>
    Balance: <input type="text" name="bal"><br><br>
    <input type="submit" value="Save">
</form>

<hr>

<%
Connection con = null;
PreparedStatement ps = null;
Statement st = null;
ResultSet rs = null;

try {
    Class.forName("oracle.jdbc.driver.OracleDriver");

    con = DriverManager.getConnection(
        "jdbc:oracle:thin:@localhost:1521:XE",
        "Atharv",
        "123"   // replace with your password
    );

    String ano = request.getParameter("ano");

    // Insert if form submitted
    if (ano != null) {

        String type = request.getParameter("type");
        double bal = Double.parseDouble(request.getParameter("bal"));

        String sql = "INSERT INTO ACCOUNT_INFO VALUES (?, ?, ?)";
        ps = con.prepareStatement(sql);

        ps.setInt(1, Integer.parseInt(ano));
        ps.setString(2, type);
        ps.setDouble(3, bal);

        ps.executeUpdate();
        out.println("<b>Record Inserted Successfully!</b><br><br>");
    }

    // Display Table
    st = con.createStatement();
    rs = st.executeQuery("SELECT * FROM ACCOUNT_INFO");

%>

<h2>Account Records</h2>

<table border="1" cellpadding="5">
<tr>
    <th>Account No</th>
    <th>Type</th>
    <th>Balance</th>
</tr>

<%
    while (rs.next()) {
%>
<tr>
    <td><%= rs.getInt("ANO") %></td>
    <td><%= rs.getString("TYPE") %></td>
    <td><%= rs.getDouble("BAL") %></td>
</tr>
<%
    }
%>

</table>

<%
} catch(Exception e) {
    out.println(e);
} finally {
    if(rs!=null) rs.close();
    if(ps!=null) ps.close();
    if(st!=null) st.close();
    if(con!=null) con.close();
}
%>

</body>
</html>
