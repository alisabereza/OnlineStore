<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Manufacturer Details</title>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet"/>
</head>
<body>
<c:import url="${contextPath}/WEB-INF/view/navibar.jsp"/>
<div align="center">
    <table class="zui-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Products</th>

        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <c:out value="${manufacturer.id}"/>
            </td>
            <td>
                <c:out value="${manufacturer.name}"/>
            </td>
            <td>
                <ul>
                    <c:choose>
                        <c:when test="${not empty manufacturer.products}">
                            <c:forEach items="${manufacturer.products}" var="product">
                                <li><a href="${pageContext.request.contextPath}/product/get?id=${product.id}" class="button"
                                       role="button"
                                       tabindex="0">${product.name} ${product.price}</a><br>
                                </li>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <p>No products yet</p>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </td>

        </tr>
        </tbody>
    </table>
    <div align="left">
        <a href="${pageContext.request.contextPath}/product/create?manufacturer_id=${manufacturer.id}"
           class="button"
           role="button"
           tabindex="0">Add product</a>
    </div>
</div>
</body>
</html>