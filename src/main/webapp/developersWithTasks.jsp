<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>All Developers with Tasks</title>
</head>
<body>
    <h1>All Developers with Tasks</h1>
   <table border="1" cellpadding="4" cellspacing="0">
        <tr>
            <th>Developer ID</th>
            <th>Name</th>
            <th>Email</th>
           
            <th>Task Name</th>
            <th>Status</th>
        </tr>

        <c:forEach var="dev" items="${developers}">
            <c:forEach var="task" items="${dev.tasks}">
                <tr>
                    <td>${dev.id}</td>
                    <td>${dev.name}</td>
                    <td>${dev.email}</td>
                    
                    <td>${task.taskName}</td>
                    <td>${task.taskStatus}</td>
                </tr>
            </c:forEach>

            <!-- if no tasks, still show developer row -->
            <c:if test="${empty dev.tasks}">
                <tr>
                    <td>${dev.id}</td>
                    <td>${dev.name}</td>
                    <td>${dev.email}</td>
                    <td colspan="3">No tasks assigned</td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</body>
</html>
