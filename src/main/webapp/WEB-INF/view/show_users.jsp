
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html >
<head>
    <title>Users</title>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet"/>
</head>
<body>
<c:import url="${contextPath}/WEB-INF/view/navibar.jsp"/>
<c:if test="${not empty users}">
    <table class="zui-table myform">
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Role</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>
                        ${user.firstName}
                </td>
                <td>
                        ${user.lastName}
                </td>
                <td>
                        ${user.email}
                </td>
                <td>
                        ${user.userRole}
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/user/edit/${user.id}" class="button"
                       role="button" tabindex="0">Edit</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/user/delete/${user.id}" class="button"
                       role="button" tabindex="0">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>