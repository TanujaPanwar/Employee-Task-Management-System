<%@page import="com.etm.entity.Task" %>
<%@page import="java.util.List" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" 
           pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Tasks</title></head>
<body>
    <%
    List<Task> list=(List<Task>)request.getAttribute("emptask");
    for(Task task:list){
    	
    	%>
    	<h1><%=task.getTaskId() %></h1>
    	<h1><%=task.getTaskName() %></h1>
    	<h1><%=task.getDuration() %></h1>
    	<h1><%=task.getTaskStatus() %></h1>
    	<% 
    }
    %>
</body>
</html>
