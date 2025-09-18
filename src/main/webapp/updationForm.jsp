<%@ page import="com.etm.entity.Employee" %>
<%
    Employee emp = (Employee) request.getAttribute("employee");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
</head>
<body>
<h2>Update Employee Details</h2>

<form action="saveUpdate" >
    <input type="text" name="id" value="<%= emp.getId() %>">

    Name: <input type="text" name="name" value="<%= emp.getName() %>"><br><br>
    Email: <input type="text" name="email" value="<%= emp.getEmail() %>"><br><br>
    Password: <input type="text" name="password" value="<%= emp.getPassword() %>"><br><br>
    Salary: <input type="text" name="salary" value="<%= emp.getSalary() %>"><br><br>
    Age: <input type="text" name="age" value="<%= emp.getAge() %>"><br><br>
    Phone: <input type="text" name="phone" value="<%= emp.getPhoneNumber() %>"><br><br>

    <input type="submit" value="Save Update">
</form>

</body>
</html>
