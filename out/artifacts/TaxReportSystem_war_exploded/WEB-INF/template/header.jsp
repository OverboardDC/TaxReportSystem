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
            <div class="navbar-nav">
                <a href="#" class="nav-item nav-link text-light">
                    <fmt:message key="create.report" bundle="${bundle}"/></a>
                <a href="#" class="nav-item nav-link text-light">
                    <fmt:message key="my.reports" bundle="${bundle}"/></a>
                <a href="#" class="nav-item nav-link text-light">
                    <fmt:message key="help" bundle="${bundle}"/></a>
                <a href="<c:url value="/app/loginPage"/>" class="nav-item nav-link text-light">
                    <fmt:message key="login" bundle="${bundle}"/></a>
                <form action="<c:url value="/app/changeLanguage"/>">
                    <select class="nav-item" name="lang" onchange="this.form.submit()">
                        <option value="en" ${sessionScope.lang == 'en' ? 'selected="selected"' : ''}>English</option>
                        <option value="ru" ${sessionScope.lang == 'ru' ? 'selected="selected"' : ''}>Russian</option>
                    </select>
                </form>
            </div>
        </nav>
    </div>
</header>
