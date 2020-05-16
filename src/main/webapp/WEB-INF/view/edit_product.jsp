<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Edit Product Details




    </title>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet"/>
</head>
<body>
<c:import url="${contextPath}/WEB-INF/view/navibar.jsp"/>

<div id="stylized" class="myform">
    <form:form id="form" name="form" method="post" action="/product/editsave" modelAttribute="product">
        <h1>Edit Project form</h1>

        <label>Product Name
            <span class="small">Product Name</span>
        </label>
        <form:input type="text" path="name" id="name"/> <form:errors path="name" cssClass="error"/>

        <label>Price

            <span class="small">Price</span>
        </label>
        <form:input type="text" path="price" id="price"/> <form:errors path="price" cssClass="error"/>

        <label>Manufacturer
            <span class="small">Select Manufacturer</span>
        </label>


        <tr>
            <td><form:label path="manufacturer">Manufacturer:</form:label></td>
            <td>
                <form:select path="manufacturer.name" cssStyle="width: 150px;">
                    <form:option value="2">Select manufacturer</form:option>
                    <c:forEach items="${manufacturers}" var="manufacturer">
                        <form:option value="${manufacturer.name}">${manufacturer.name}</form:option>
                    </c:forEach>
                </form:select>
            </td>
        </tr>

        <button type="submit" class="button">Save</button>
        <div class="spacer"></div>
    </form:form>
    <c:if test="${not empty errors}">
        <c:forEach items="${errors}" var="error">
            <p style="color: red">${error.field} ${error.error}</p>
        </c:forEach>
    </c:if>
</div>

</body>
</html>