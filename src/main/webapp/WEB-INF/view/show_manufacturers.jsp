<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication property="principal" />
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Manufacturers</title>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet"/>
</head>
<body>
<c:import url="${contextPath}/WEB-INF/view/navibar.jsp"/>
<c:choose>
    <c:when test="${not empty manufacturers}">
        <table class="zui-table myform">
            <thead>
            <tr>
                <th>Manufacturer ID</th>
                <th>Name</th>
                <th>Details</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${manufacturers}" var="manufacturer">
                <tr>
                    <td>
                        <c:out value="${manufacturer.id}"/>
                    </td>
                    <td>
                        <c:out value="${manufacturer.name}"/>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/manufacturer/get?id=${manufacturer.id}" class="button"
                           role="button" tabindex="0">Detailed</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/manufacturer/edit/${manufacturer.id}" class="button"
                           role="button" tabindex="0">Edit</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/manufacturer/delete/${manufacturer.id}" class="button"
                           role="button" tabindex="0">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <p>There is no manufacturers, please contact admin</p>
    </c:otherwise>
</c:choose>
</body>
</html>