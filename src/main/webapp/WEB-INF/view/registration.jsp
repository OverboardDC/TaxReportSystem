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
                <h1 class="text-center"><fmt:message key="registration" bundle="${bundle}"/></h1>

                <h6 class="text-danger">${sessionScope.client_type_error}</h6>
                <c:remove var="client_type_error" scope="session"/>
                <label><fmt:message key="choose.person-type" bundle="${bundle}"/></label>
                <input type="hidden" value="${sessionScope.last_client_type}" id="last_client_type">
                <select id="client_type_select" class="nav-item input-group" title="Option" name="client_type" required>
                    <option selected disabled class="hidden">
                        <fmt:message key="select.type" bundle="${bundle}"/></option>
                    <option id="individual" onchange="alert('lol')"
                            value="individual" ${sessionScope.last_client_type == 'individual' ? 'selected="selected"' : ''}>
                        <fmt:message key="individual" bundle="${bundle}"/></option>
                    <option id="company"
                            value="company" ${sessionScope.last_client_type == 'company' ? 'selected="selected"' : ''}>
                        <fmt:message key="company" bundle="${bundle}"/></option>
                </select>
                <c:remove var="last_client_type" scope="session"/>

                <div id="individual_items" class="hidden">

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

                </div>
                <div id="company_items" class="hidden">

                    <h6 class="text-danger">${sessionScope.name_error}</h6>
                    <c:remove var="name_error" scope="session"/>
                    <label><fmt:message key="name.in" bundle="${bundle}"/></label>
                    <input class="input-group" name="name">

                </div>
                <div id="items_for_all">

                    <h6 class="text-danger">${sessionScope.username_error}</h6>
                    <c:remove var="username_error" scope="session"/>
                    <label><fmt:message key="username.in" bundle="${bundle}"/></label>
                    <input class="input-group" name="username">

                    <h6 class="text-danger">${sessionScope.password_error}</h6>
                    <c:remove var="password_error" scope="session"/>
                    <label><fmt:message key="password.in" bundle="${bundle}"/></label>
                    <input type="password" class="input-group" name="password">

                    <h6 class="text-danger">${sessionScope.password_repeat_error}</h6></label>
                    <c:remove var="password_repeat_error" scope="session"/>
                    <label><fmt:message key="password.repeat.in" bundle="${bundle}"/></label>
                    <input type="password" class="input-group" name="password_repeat">

                    <button class="btn btn-success"><fmt:message key="submit" bundle="${bundle}"/></button>
                </div>

            </form>
        </div>
    </section>
</div>

<script rel="script" src="<c:url value="/resources/js/jquery.js"/>"></script>
<script rel="script" src="<c:url value="/resources/js/script.js"/>"></script>
</body>


</html>
