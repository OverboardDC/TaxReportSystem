<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../template/head.jsp"/>
<body>

<div class="wrapper">
    <jsp:include page="../template/header.jsp"/>
    <section>

        <div class="row justify-content-center text-center">
            <h1>Inspector page</h1>
        </div>
        <div class="row justify-content-start">
            <c:forEach var="report" items="${requestScope.reports}">
                <div class="bg-light col-md-3 report_div">
                    <div class="form-group">
                        <h6>Client: </h6>
                        <p>${report.taxPayer.firstName} ${report.taxPayer.lastName}</p>
                        <h6>Status: </h6>
                        <p class="text-info">${report.status}</p>
                        <h6>Period from: </h6>
                        <p>${report.periodFrom}</p>
                        <h6>Period to: </h6>
                        <p>${report.periodTo}</p>
                        <h6>Submission date </h6>
                        <fmt:parseDate value="${report.submissionDate}"
                                       var="parsedDate" type="both" pattern="yyyy-MM-dd'T'HH:mm"/>
                        <fmt:formatDate value="${parsedDate}" var="stdDatum"
                                        type="date" pattern="dd-MM-yyyy HH:mm"/>
                        <p>${stdDatum}</p>
                        <c:if test="${not empty report.commentary}">
                            <h6>Commentary: </h6>
                            <p>${report.commentary}</p>
                        </c:if>
                        <a href="#" class="btn btn-success">Accept</a>
                    </div>
                    <div class="form-group">
                        <form>
                            <div class="form-group">
                                <label>Reject reason:</label>
                                <textarea class="input-group" placeholder="Reason:"></textarea>
                            </div>
                            <button class="btn btn-danger">Reject</button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </section>
</div>
</body>
</html>
