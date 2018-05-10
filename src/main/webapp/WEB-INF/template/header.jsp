<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:include page="../template/localisation.jsp"/>

<header>
    <div class="row">
        <nav class="navbar bg-dark navbar-expand-md navbar-light col justify-content-between">

            <a href="<c:url value="/app/homePage"/>"><h1 class="text-light navbar-brand">
                <fmt:message key="tax.reporting.system" bundle="${bundle}"/></h1>
            </a>

            <c:if test="${not empty sessionScope.user}">
                <h6 class="nav-item text-light"><fmt:message key="welcome.user" bundle="${bundle}"/>
                        ${sessionScope.user.firstName}</h6>
            </c:if>
            <div class="navbar-nav">

                <c:if test="${sessionScope.user.role.get() == 'CLIENT'}">
                    <a href="<c:url value="/app/client/newReportPage"/>" class="nav-item nav-link text-light">
                        <fmt:message key="create.report" bundle="${bundle}"/></a>
                    <a href="<c:url value="/app/client/taxPayerPage"/>" class="nav-item nav-link text-light">
                        <fmt:message key="my.reports" bundle="${bundle}"/></a>
                </c:if>

                <c:if test="${sessionScope.user.role.get() == 'ADMIN'}">
                    <a href="<c:url value="/app/admin/adminPage"/>" class="nav-item nav-link text-light">
                        <fmt:message key="admin.page" bundle="${bundle}"/></a>
                </c:if>

                <c:if test="${sessionScope.user.role.get() == 'INSPECTOR'}">
                    <a href="<c:url value="/app/inspector/testInspectorPage"/>" class="nav-item nav-link text-light">
                        <fmt:message key="inspector.page" bundle="${bundle}"/></a>
                </c:if>

                <c:if test="${empty sessionScope.user}">
                    <a href="<c:url value="/app/loginPage"/>" class="nav-item nav-link text-light">
                        <fmt:message key="login" bundle="${bundle}"/></a>
                </c:if>

                <a href="#" class="nav-item nav-link text-light">
                    <fmt:message key="help" bundle="${bundle}"/></a>

                <c:if test="${not empty sessionScope.user}">
                    <a href="<c:url value="/app/redirect/logout"/>" class="nav-item nav-link text-light">
                        <fmt:message key="logout" bundle="${bundle}"/></a>
                </c:if>
                <div class="nav-item">
                    <form action="<c:url value="/app/redirect/changeLanguage"/>">
                        <select class="input-group" name="lang" onchange="this.form.submit()">
                            <option value="en" ${sessionScope.lang == 'en' ? 'selected="selected"' : ''}>English
                            </option>
                            <option value="ru" ${sessionScope.lang == 'ru' ? 'selected="selected"' : ''}>Russian
                            </option>
                        </select>
                    </form>
                </div>

            </div>
        </nav>
    </div>
</header>
