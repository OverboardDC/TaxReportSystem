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

                    <h6 class="text-danger">${sessionScope.first_name_error}</h6>
                    <c:remove var="first_name_error" scope="session"/>
                    <label><fmt:message key="first.name.in" bundle="${bundle}"/></label>
                    <input class="input-group" name="first_name">

                    <h6 class="text-danger">${sessionScope.last_name_error}</h6>
                    <c:remove var="last_name_error" scope="session"/>
                    <label><fmt:message key="last.name.in" bundle="${bundle}"/></label>
                    <input class="input-group" name="last_name">

                    <h6 class="text-danger">${sessionScope.identification_code_error}</h6>
                    <c:remove var="identification_code_error" scope="session"/>
                    <label><fmt:message key="identification.code.in" bundle="${bundle}"/></label>
                    <input class="input-group" name="identification_code">

                    <h6 class="text-danger">${sessionScope.username_error}</h6>
                    <c:remove var="username_error" scope="session"/>
                    <label><fmt:message key="username.in" bundle="${bundle}"/></label>
                    <input class="input-group" name="username">

                    <h6 class="text-danger">${sessionScope.password_error}</h6>
                    <c:remove var="password_error" scope="session"/>
                    <label><fmt:message key="password.in" bundle="${bundle}"/></label>
                    <input type="password" class="input-group" name="password">

                    <h6 class="text-danger">${sessionScope.password_repeat_error}</h6>
                    <c:remove var="password_repeat_error" scope="session"/>
                    <label><fmt:message key="password.repeat.in" bundle="${bundle}"/></label>
                    <input type="password" class="input-group" name="password_repeat">
                </div>

                <button class="btn btn-success"><fmt:message key="submit" bundle="${bundle}"/></button>

            </form>
        </div>
    </section>
</div>
</body>
</html>
