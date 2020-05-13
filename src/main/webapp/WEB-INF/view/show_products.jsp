<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Products</title>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet"/>
</head>
<body>
<c:import url="${contextPath}/WEB-INF/view/navibar.jsp"/>
<c:if test="${not empty products}">
    <table class="zui-table myform">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Manufacturer</th>
            <th>Edit</th>
            <th>Delete</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>
                        ${product.id}
                </td>
                <td>
                        ${product.name}
                </td>
                <td>
                        ${product.price}
                </td>
                <td>
                    ${product.manufacturer.name}
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/product/edit/${product.id}" class="button"
                       role="button" tabindex="0">Edit</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/product/delete/${product.id}" class="button"
                       role="button" tabindex="0">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>