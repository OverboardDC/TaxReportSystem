<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../template/head.jsp"/>
<body>
<div class="wrapper">
    <jsp:include page="../template/header.jsp"/>
    <section>
        <div class="row justify-content-center">

            <form class="form-group col-md-4">
                <h1 class="text-center">Login</h1>
                <input placeholder="Username" name="username" class="input-group">
                <input placeholder="Password" name="password"class="input-group">
                <a href="<c:url value="/app/registrationPage"/>" class="input-group">Create account</a>
                <button class="btn btn-success">Login</button>
            </form>
        </div>
    </section>
</div>
</body>
</html>
