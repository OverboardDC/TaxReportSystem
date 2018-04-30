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
                <h1 class="text-center"><fmt:message key="registration" bundle="${bundle}"/></h1>
                <label><fmt:message key="choose.person-type" bundle="${bundle}"/></label>

                <select id="client_type_select" class="nav-item input-group" title="Option" required>
                    <option selected disabled class="hidden">
                        <fmt:message key="select.type" bundle="${bundle}"/></option>
                    <option id="individual" value="individual"><fmt:message key="individual" bundle="${bundle}"/></option>
                    <option id="company" value="company"><fmt:message key="company" bundle="${bundle}"/></option>
                </select>

                <div id="individual_items" class="hidden">
                    <label><fmt:message key="first.name.in" bundle="${bundle}"/></label>
                    <input class="input-group" name="first_name">

                    <label><fmt:message key="last.name.in" bundle="${bundle}"/></label>
                    <input class="input-group" name="last_name">

                    <label><fmt:message key="identification.code.in" bundle="${bundle}"/></label>
                    <input class="input-group" name="identification_code">
                </div>
                <div id="company_items" class="hidden">
                    <label><fmt:message key="name.in" bundle="${bundle}"/></label>
                    <input class="input-group" name="company_name">
                </div>
                <div id="items_for_all">

                    <label><fmt:message key="username.in" bundle="${bundle}"/></label>
                    <input class="input-group" name="username">

                    <label><fmt:message key="password.in" bundle="${bundle}"/></label>
                    <input class="input-group" name="password">

                    <label><fmt:message key="password.repeat.in" bundle="${bundle}"/></label>
                    <input class="input-group" name="password_repeat">

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
