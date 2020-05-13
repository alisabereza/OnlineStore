<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <link href="${contextPath}/resources/css/style.css" rel="stylesheet"/>
</head>

<body>
<c:import url="${contextPath}/WEB-INF/view/navibar.jsp"/>
<div class="form-container">

    <h1>Edit Manufacturer Details</h1>

    <form:form method="POST" modelAttribute="manufacturer"  class="form-horizontal" action="/manufacturer/editsave">

        <div class="row">
            <div class="form-group col-md-12">
                <div class="col-md-7">
                    <form:hidden path="id"  class="form-control input-sm"/>
                    <div class="has-error">
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="name">Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="name" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>



        <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" value="Edit" class="btn btn-primary btn-sm">
            </div>
        </div>
    </form:form>
</div>
</body>
</html>