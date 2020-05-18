<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create User</title>
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet"/>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet"/>
</head>

<body>
<c:import url="${contextPath}/WEB-INF/view/navibar.jsp"/>
<div class="container">
    <form:form method="POST" modelAttribute="userForm" class="form-signin" action="/user/createUser">
        <h2 class="form-signin-heading">User data</h2>
<%--        <spring:bind path="id">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:hidden path="id" class="form-control" placeholder="ID"></form:hidden>
                <form:errors path="id"></form:errors>
            </div>
        </spring:bind>--%>

        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="firstName" class="form-control" placeholder="first name"
                            autofocus="true"></form:input>
                <form:errors path="firstName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="lastName" class="form-control" placeholder="last name"
                            autofocus="true"></form:input>
                <form:errors path="lastName"></form:errors>
            </div>
        </spring:bind>

        <span>${message}</span>
        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="email" class="form-control" placeholder="Username(use email as user name)"
                            autofocus="true"></form:input>
                <form:errors path="email"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="password" class="form-control" placeholder="password"
                            autofocus="true"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="userRole">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:select path="userRole" id="userRole" class="form-control input-sm" autofocus="true">>
                    <form:option value="">Select Role</form:option>
                    <form:options items="${userRoles}" />
                </form:select>
                <form:errors path="userRole"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="status">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:select path="status" id="status" class="form-control input-sm" autofocus="true">>
                    <form:option value="">Select Status</form:option>
                    <form:options items="${userStatuses}" />
                </form:select>
                <form:errors path="status"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
    </form:form>
</div>

</body>
</html>