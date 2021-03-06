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
    <title>Employee form</title>
</head>
<body>
<form action="/Dispatcher" method="get">
    <input type="button" value="Home" onclick="location.href='index.jsp';">
    <input type="hidden" name="entity" value="EmployeeMerge">
    <input type="submit" value="Add">
</form>
<form action="/EmployeeAct" method="post">
    Employee NumberAdd: <input type="number" name="empNum">
    <input type="hidden" name="crud" value="read">
    <input type="submit" value="ShowEmployee">
</form>
<form action="EmployeeAct" method="get">
    <input type="hidden" name="crud" value="report">
    Employee Number: <input type="number" name="empNum">
    <input type="submit" value="ReportEmployee">
</form>
<table border="1">
    <tr>
        <td>employeeNumber</td>
        <td>lastName</td>
        <td>firstName</td>
        <td>extension</td>
        <td>email</td>
        <td>officeCode</td>
        <td>reportsTo</td>
        <td>jobTitle</td>
        <td>edit</td>
        <td>delete</td>
    </tr>
    <%
    List<Employee> emps = (List<Employee>)request.getAttribute("employees");
    if(emps!=null){
        for (Employee employee:emps){
           if(employee!=null){
    %>
    <tr>
        <td><a href="/EmployeeAct?manageof=<%=employee.getEmployeeNumber()%>&crud=mngof"> <%=employee.getEmployeeNumber()%> </a></td>
        <td><%=employee.getLastName()%></td>
        <td><%=employee.getFirstName()%></td>
        <td><%=employee.getExtension()%></td>
        <td><%=employee.getEmail()%></td>
        <td><%=employee.getOfficeCode()%></td>
        <td><a href="/EmployeeAct?manageby=<%=employee.getReportsTo()%>&crud=mngby"> <%=employee.getReportsTo()%> </a></td>
        <td><%=employee.getJobTitle()%></td>
        <td><a href="/EmployeeAct?employeenum=<%=employee.getEmployeeNumber()%>&crud=edit"> edit </a></td>
        <td><a href="/EmployeeAct?employeenum=<%=employee.getEmployeeNumber()%>&crud=delete"> delete </a></td>
    </tr>
<%}}}%>
</table>
</body>
</html>