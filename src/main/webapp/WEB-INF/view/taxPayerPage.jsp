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
            <h1><fmt:message key="my.reports" bundle="${bundle}"/></h1>
        </div>
        <div class="row justify-content-between">
            <div class="col-md-9">
                <c:if test="${not empty requestScope.inspector}">
                    <h4><fmt:message key="inspector.is" bundle="${bundle}"/>
                            ${requestScope.inspector.firstName} ${requestScope.inspector.lastName}</h4>
                </c:if>
                <c:if test="${empty requestScope.inspector}">
                    <h4 class="text-danger"><fmt:message key="inspector.was.not.assigned" bundle="${bundle}"/></h4>
                </c:if>
            </div>
            <c:if test="${not empty requestScope.inspector}">
                <div class="col-md-4">
                    <a href="<c:url value="/app/client/newReportPage"/>" class="btn btn-success"><fmt:message key="create.report" bundle="${bundle}"/></a>
                    <a href="<c:url value="/app/client/requestPage"/>" class="btn btn-danger">
                        <fmt:message key="change.inspector" bundle="${bundle}"/></a>
                </div>
            </c:if>
        </div>
        <div class="row justify-content-start">
            <c:forEach var="report" items="${requestScope.reports}">
                <div class="bg-light col-md-3 report_div">
                    <h6><fmt:message key="inspector" bundle="${bundle}"/>: </h6>
                    <p>${report.inspector.firstName} ${report.inspector.lastName}</p>
                    <h6><fmt:message key="status" bundle="${bundle}"/>: </h6>
                    <p class="text-info">${report.status}</p>
                    <h6><fmt:message key="period.from" bundle="${bundle}"/>: </h6>
                    <p>${report.periodFrom}</p>
                    <h6><fmt:message key="period.to" bundle="${bundle}"/>: </h6>
                    <p>${report.periodTo}</p>
                    <h6><fmt:message key="submission.date" bundle="${bundle}"/>: </h6>
                    <ct:formatDateTime dateTime="${report.submissionDate}"/>
                    <c:if test="${not empty report.commentary}">
                        <h6><fmt:message key="commentary" bundle="${bundle}"/>: </h6>
                        <p>${report.commentary}</p>
                    </c:if>
                    <c:if test="${report.status == 'REJECTED'}">
                        <h6><fmt:message key="reject.reason" bundle="${bundle}"/>: </h6>
                        <p>${report.rejectReason}</p>
                        <c:url value="/app/client/editReportPage" var="editReport">
                            <c:param name="report_id" value="${report.id}"/>
                        </c:url>
                        <a href="${editReport}">Edit report</a>
                    </c:if>
                    <c:if test="${not empty report.editionDate}">
                        <h6><fmt:message key="last.edit.date" bundle="${bundle}"/>: </h6>
                        <ct:formatDateTime dateTime="${report.editionDate}"/>
                    </c:if>
                </div>
            </c:forEach>
        </div>
    </section>
</div>
</body>
</html>
