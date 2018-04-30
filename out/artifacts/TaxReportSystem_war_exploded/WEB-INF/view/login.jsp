<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../template/head.jsp"/>
<body>
<div class="wrapper">
    <jsp:include page="../template/header.jsp"/>
    <section>
        <div class="row justify-content-center">

            <form class="form-group col-md-4">
                <h1 class="text-center"><fmt:message key="login" bundle="${bundle}"/></h1>
                <input placeholder="<fmt:message key="username" bundle="${bundle}"/>" name="username" class="input-group">
                <input placeholder="<fmt:message key="password" bundle="${bundle}"/>"class="input-group">
                <a href="<c:url value="/app/registrationPage"/>" class="input-group">
                    <fmt:message key="create.account" bundle="${bundle}"/></a>
                <button class="btn btn-success"><fmt:message key="to.login" bundle="${bundle}"/></button>
            </form>
        </div>
    </section>
</div>
</body>
</html>
