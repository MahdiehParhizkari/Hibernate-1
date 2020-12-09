<%--
  @Project     order
  @Author      Afshin Parhizkari
  @Date        2020 - 12 - 05
  @Time        2:11 PM
  Created by   IntelliJ IDEA
  Email:       Afshin.Parhizkari@gmail.com
  Description:
--%>

<%@ page import="com.afshin.Entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <th>
        <td>employeeNumber</td>
        <td>lastName</td>
        <td>firstName</td>
        <td>extension</td>
        <td>email</td>
        <td>officeCode</td>
        <td>reportsTo</td>
        <td>jobTitle</td>
    </th>
<%
    List<Employee> emps = (List<Employee>)request.getAttribute("employees");
    for (Employee employee:emps){
%>
    <tr>
        <td><%=employee.getEmployeeNumber()%></td>
        <td><%=employee.getLastName()%></td>
        <td><%=employee.getFirstName()%></td>
        <td><%=employee.getExtension()%></td>
        <td><%=employee.getEmail()%></td>
        <td><%=employee.getOfficeCode()%></td>
        <td><%=employee.getReportsTo()%></td>
        <td><%=employee.getJobTitle()%></td>
    </tr>
<%}%>
</table>
</body>
</html>