<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Create Manufacturer</title>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet"/>

</head>
<body>
<c:import url="${contextPath}/WEB-INF/view/navibar.jsp"/>

<div id="stylized" class="myform">
    <form:form id="form" name="form" method="post" action="createManufacturer" modelAttribute="manufacturer">
        <h1>Create Manufacturer form</h1>

        <label>Manufacturer Name
            <span class="small">Manufacturer Name</span>
        </label>
        <form:input type="text" path="name" id="name"/> <form:errors path="name" cssClass="error"/>

        <button type="submit" class="button">Create</button>
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