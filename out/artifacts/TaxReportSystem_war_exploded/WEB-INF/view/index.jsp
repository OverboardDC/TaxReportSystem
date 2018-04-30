<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../template/head.jsp"/>
<body>

<div class="wrapper">
    <jsp:include page="../template/header.jsp"/>
    <section>
        <div class="row">
            <div class="text-center col-12">
                <h1><fmt:message key="welcome" bundle="${bundle}"/></h1>
                <img src="<c:url value="/resources/img/main_image.jpg"/>" class="main_image">
                <h6><fmt:message key="in.order.to.create.report" bundle="${bundle}"/></h6>
                <div class="text-center col">
                    <a href="<c:url value="/app/loginPage"/>">
                        <fmt:message key="i.have.account" bundle="${bundle}"/></a>
                </div>
                <div class="text-center col">
                    <a href="<c:url value="/app/registrationPage"/>">
                        <fmt:message key="i.am.new.user" bundle="${bundle}"/></a>
                </div>
            </div>
            <div class="col">

            </div>
        </div>
    </section>
</div>
</body>
</html>
