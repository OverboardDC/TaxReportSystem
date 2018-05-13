<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ct" uri="/WEB-INF/tag/dateFormatTag.tld" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../template/head.jsp"/>
<body>

<div class="wrapper">
    <jsp:include page="../template/header.jsp"/>
    <section>

        <div class="row justify-content-center text-center">
            <h1><fmt:message key="inspector.page" bundle="${bundle}"/></h1>
        </div>
        <h6 class="text-danger">${sessionScope.inspector_page_error}</h6>
        <c:remove var="inspector_page_error" scope="session"/>
        <div class="row justify-content-start">
            <c:forEach var="report" items="${requestScope.reports}">
                <div class="bg-light col-md-3 report_div">
                    <h6><fmt:message key="client" bundle="${bundle}"/>: </h6>
                    <p>${report.taxPayer.firstName} ${report.taxPayer.lastName}</p>
                    <h6 class="status"><fmt:message key="status" bundle="${bundle}"/>: </h6>
                    <p class="text-info"><fmt:message key="${report.status.toString().toLowerCase()}" bundle="${bundle}"/></p>
                    <h6><fmt:message key="period.from" bundle="${bundle}"/>: </h6>
                    <p><ct:formatDate date="${report.periodFrom}"/></p>
                    <h6><fmt:message key="period.to" bundle="${bundle}"/>: </h6>
                    <p><ct:formatDate date="${report.periodTo}"/></p>
                    <h6><fmt:message key="submission.date" bundle="${bundle}"/>: </h6>
                    <p><ct:formatDateTime dateTime="${report.submissionDate}"/></p>
                    <c:if test="${not empty report.commentary}">
                        <h6><fmt:message key="commentary" bundle="${bundle}"/>: </h6>
                        <p>${report.commentary}</p>
                    </c:if>
                    <c:if test="${not empty report.rejectReason}">
                        <h6><fmt:message key="reject.reason" bundle="${bundle}"/>: </h6>
                        <p>${report.rejectReason}</p>
                    </c:if>
                    <c:if test="${not empty report.editionDate}">
                        <h6><fmt:message key="last.edit.date" bundle="${bundle}"/>: </h6>
                        <p><ct:formatDateTime dateTime="${report.editionDate}"/></p>
                    </c:if>
                    <c:if test="${report.status == 'PENDING'}">
                        <div class="form-group">
                            <c:url value="/app/redirect/inspector/approveReport" var="approveReport">
                                <c:param name="report_id" value="${report.id}"/>
                            </c:url>
                            <a href="${approveReport}" class="btn btn-success"><fmt:message key="approve"
                                                                                            bundle="${bundle}"/></a>
                        </div>
                        <form method="post" action="<c:url value="/app/redirect/inspector/rejectReport"/>">
                            <input hidden name="report_id" value="${report.id}">
                            <div class="form-group">
                                <label><fmt:message key="reject.reason" bundle="${bundle}"/>:</label>
                                <textarea name="reject_reason" class="input-group"
                                          placeholder="<fmt:message key="reason" bundle="${bundle}"/>:"></textarea>
                            </div>
                            <button class="btn btn-danger"><fmt:message key="reject" bundle="${bundle}"/></button>
                        </form>
                    </c:if>
                </div>
            </c:forEach>
        </div>
    </section>
</div>
</body>
</html>
