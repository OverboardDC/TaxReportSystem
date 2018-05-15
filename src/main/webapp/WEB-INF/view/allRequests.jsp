<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ct" uri="/WEB-INF/tag/customTags.tld" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../template/head.jsp"/>
<body>

<div class="wrapper">
    <jsp:include page="../template/header.jsp"/>
    <section>
        <div class="row justify-content-center text-center">
            <h1><fmt:message key="requests" bundle="${bundle}"/></h1>
        </div>
        <h4 class="text-danger">${sessionScope.all_requests_page_error}</h4>
        <c:remove var="all_requests_page_error" scope="session"/>
        <div class="row justify-content-start">
            <c:forEach var="request" items="${requestScope.requests}">
                <div class="bg-light item col-md-3">
                    <div class="form-group">
                        <h4>${request.taxPayer.firstName} ${request.taxPayer.lastName}</h4>
                        <h6><fmt:message key="username.in" bundle="${bundle}"/> ${request.taxPayer.username}</h6>
                        <h6><fmt:message key="identification.code.in"
                                         bundle="${bundle}"/> ${request.taxPayer.identificationCode}</h6>
                        <h6><fmt:message key="inspector.in"
                                         bundle="${bundle}"/> ${request.inspector.firstName} ${request.inspector.lastName}</h6>
                        <h6><fmt:message key="reason.in" bundle="${bundle}"/></h6>
                        <p>${request.reason}</p>
                        <h6><fmt:message key="submission.date" bundle="${bundle}"/>:</h6>
                        <p><ct:formatDateTime dateTime="${request.submissionDate}"/></p>
                        <form action="<c:url value="/app/redirect/admin/acceptRequest"/>" method="post">
                            <div class="form-group">

                                <label><fmt:message key="choose.new.inspector" bundle="${bundle}"/></label>
                                <select class="input-group" name="inspector_id">
                                    <option selected disabled class="hidden"><fmt:message key="select"
                                                                                          bundle="${bundle}"/></option>
                                    <c:forEach items="${requestScope.inspectors}" var="inspector">
                                        <option value="${inspector.id}">${inspector.firstName} ${inspector.lastName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <input hidden name="request_id" value="${request.id}">
                            <input hidden name="tax_payer_id" value="${request.taxPayer.id}">
                            <button class="btn bg-success text-light"><fmt:message key="accept"
                                                                                   bundle="${bundle}"/></button>
                        </form>

                        <form action="<c:url value="/app/redirect/admin/rejectRequest"/>">
                            <div class="form-group">
                                <label><fmt:message key="reason.in" bundle="${bundle}"/></label>
                                <textarea placeholder="Reason" name="reject_reason" class="input-group"></textarea>
                            </div>
                            <input hidden name="request_id" value="${request.id}">
                            <button class="btn bg-danger text-light">
                                <fmt:message key="reject" bundle="${bundle}"/></button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
        <jsp:include page="../template/pagination.jsp"/>
    </section>
</div>
</body>
</html>
