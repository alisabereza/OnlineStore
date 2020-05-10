<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>User Details</title>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet"/>
</head>
<body>
<c:import url="${contextPath}/WEB-INF/view/navibar.jsp"/>
<div align="center">
    <table class="zui-table">
        <thead>
        <tr>
            <th>Full name</th>
            <th>Email</th>
            <th>User role</th>
            <th>User status</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                ${user.firstName} ${user.lastName}
            </td>
            <td>
                ${user.email}
            </td>
            <td>
                ${user.userRole}
            </td>
            <td>
                ${user.status}
            </td>

        </tr>
        </tbody>
    </table>
</div>
</body>
</html>