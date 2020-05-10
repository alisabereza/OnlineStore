<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div class="navbar">
    <a href="${pageContext.request.contextPath}/">Home</a>
    <div class="dropdown">
        <button class="dropbtn">Manufacturer
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/manufacturer/showManufacturers">All Manufacturers</a>
            <a href="${pageContext.request.contextPath}/manufacturer/createManufacturer">Create Manufacturer</a>
            <a href="${pageContext.request.contextPath}/manufacturer/findPage">Find Manufacturer</a>
            <a href="${pageContext.request.contextPath}/manufacturer/editManufacturer">Edit Manufacturer</a>
            <a href="${pageContext.request.contextPath}/manufacturer/deleteManufacturer">Delete Manufacturer</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Product
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/product/showProducts">Show Products</a>
            <a href="${pageContext.request.contextPath}/product/createProduct">Create Product</a>
            <a href="${pageContext.request.contextPath}/product/findProduct">Find Product</a>
            <a href="${pageContext.request.contextPath}/product/editProduct">Edit Product</a>
            <a href="${pageContext.request.contextPath}/product/deleteProduct">Delete Product</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">User
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/user/showUsers">Show Users</a>
            <security:authorize access="hasRole('ROLE_ADMIN')">
                <a href="${pageContext.request.contextPath}/user/createUser">Create User</a>
            </security:authorize>
            <a href="${pageContext.request.contextPath}/user/findPage">Find User</a>
            <a href="${pageContext.request.contextPath}/user/editPage">Edit User</a>
            <a href="${pageContext.request.contextPath}/user/deletePage">Delete User</a>
        </div>
    </div>
    <div>
        <a style="float: right" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
    <div>
        <p><security:authentication property="principal.username"/></p>
    </div>
</div>