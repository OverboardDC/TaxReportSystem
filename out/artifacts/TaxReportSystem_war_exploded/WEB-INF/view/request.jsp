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
            <c:if test="${not requestScope.are_there_requests_pending}">
                <form class="form-group col-4" method="post" action="<c:url value="/app/redirect/client/sendRequest"/>">
                    <h1 class="text-center"><fmt:message key="request" bundle="${bundle}"/></h1>
                    <h3><fmt:message key="inspector.your" bundle="${bundle}"/> ${sessionScope.user.inspector.firstName}
                            ${sessionScope.user.inspector.lastName}</h3>
                    <label><fmt:message key="request.reason" bundle="${bundle}"/></label>
                    <h6 class="text-danger">${sessionScope.reason_error}</h6>
                    <c:remove var="reason_error" scope="session"/>
                    <div class="form-group">
                        <input name="tax_payer_id" hidden value="${sessionScope.user.id}">
                        <input name="inspector_id" hidden value="${sessionScope.user.inspector.id}">
                        <textarea class="input-group" name="reason"
                                  placeholder="<fmt:message key="reason.in" bundle="${bundle}"/>"></textarea>
                    </div>
                    <button class="btn bg-primary text-light"><fmt:message key="submit" bundle="${bundle}"/></button>
                </form>
            </c:if>
            <c:if test="${requestScope.are_there_requests_pending}">
                <h2><fmt:message key="request.in.process"
                                 bundle="${bundle}"/> ${request.status}</h2>
            </c:if>
        </div>
        <h2 class="text-center"><fmt:message key="previous.requests"
                                             bundle="${bundle}"/> ${request.status}</h2>
        <div class="row justify-content-start">
            <c:forEach items="${requestScope.requests}" var="request">
                <div class="col-md-3 bg-light">
                    <h6><fmt:message key="status.in"
                                     bundle="${bundle}"/> ${request.status}</h6>
                    <h6><fmt:message key="inspector.in"
                                     bundle="${bundle}"/> ${request.inspector.firstName} ${request.inspector.lastName}</h6>
                    <h6><fmt:message key="reason.in" bundle="${bundle}"/></h6>
                    <p>${request.reason}</p>
                    <c:if test="${not empty request.rejectReason}">
                        <h6><fmt:message key="reject.reason.in" bundle="${bundle}"/></h6>
                        <p>${request.rejectReason}</p>
                    </c:if>
                </div>
            </c:forEach>
        </div>

    </section>
</div>
</body>
</html>
