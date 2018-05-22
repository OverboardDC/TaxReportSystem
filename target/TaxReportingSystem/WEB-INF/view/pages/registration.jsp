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

            <form action="<c:url value="/app/redirect/registration"/>" class="form-group col-md-4" method="post">
                <div class="form-group">
                    <h1 class="text-center"><fmt:message key="registration" bundle="${bundle}"/></h1>

                    <label><fmt:message key="first.name" bundle="${bundle}"/>:*</label>
                    <h6 class="text-danger">${sessionScope.first_name_error}</h6>
                    <c:remove var="first_name_error" scope="session"/>
                    <input class="input-group" name="first_name">

                    <label><fmt:message key="last.name" bundle="${bundle}"/>:*</label>
                    <h6 class="text-danger">${sessionScope.last_name_error}</h6>
                    <c:remove var="last_name_error" scope="session"/>
                    <input class="input-group" name="last_name">

                    <label><fmt:message key="identification.code" bundle="${bundle}"/>:*</label>
                    <h6 class="text-danger">${sessionScope.identification_code_error}</h6>
                    <c:remove var="identification_code_error" scope="session"/>
                    <input class="input-group" name="identification_code">

                    <label><fmt:message key="username" bundle="${bundle}"/>:*</label>
                    <h6 class="text-danger">${sessionScope.username_error}</h6>
                    <c:remove var="username_error" scope="session"/>
                    <input class="input-group" name="username">

                    <label><fmt:message key="password" bundle="${bundle}"/>:*</label>
                    <h6 class="text-danger">${sessionScope.username_error}</h6>
                    <c:remove var="username_error" scope="session"/>
                    <input type="password" class="input-group" name="password">

                    <label><fmt:message key="password.repeat" bundle="${bundle}"/>:*</label>
                    <h6 class="text-danger">${sessionScope.username_error}</h6>
                    <c:remove var="username_error" scope="session"/>
                    <input type="password" class="input-group" name="password_repeat">
                </div>

                <button class="btn btn-success"><fmt:message key="submit" bundle="${bundle}"/></button>

            </form>
        </div>
    </section>
</div>
</body>
</html>
