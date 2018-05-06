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
            <form class="form-group col-4" method="post" action="<c:url value="/app/redirect/client/sendRequest"/>">
                <h1 class="text-center"><fmt:message key="request" bundle="${bundle}"/></h1>
                <h3><fmt:message key="inspector.your" bundle="${bundle}"/> ${sessionScope.user.inspector.firstName}
                    ${sessionScope.user.inspector.lastName}</h3>
                <label><fmt:message key="request.reason" bundle="${bundle}"/></label>
                <h6 class="text-danger">${sessionScope.reason_error}</h6>
                <c:remove var="reason_error" scope="session"/>
                <input name="tax_payer_id" hidden value="${sessionScope.user.id}">
                <input name="inspector_id" hidden value="${sessionScope.user.inspector.id}">
                <textarea class="input-group" name="reason" placeholder="<fmt:message key="reason.in" bundle="${bundle}"/>"></textarea>
                <button class="btn bg-primary text-light"><fmt:message key="submit" bundle="${bundle}"/></button>
            </form>
        </div>
    </section>
</div>
</body>
</html>
