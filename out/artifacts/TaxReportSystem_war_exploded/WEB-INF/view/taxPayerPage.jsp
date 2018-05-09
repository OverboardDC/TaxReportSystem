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
            <c:if test="${not empty sessionScope.user.inspector}">
                <div class="col-md-4">
                    <a href="#" class="btn btn-success"><fmt:message key="create.report" bundle="${bundle}"/></a>
                    <a href="<c:url value="/app/client/requestPage"/>" class="btn btn-danger">
                        <fmt:message key="change.inspector" bundle="${bundle}"/></a>
                </div>
            </c:if>
        </div>
        <div class="row justify-content-start">
            <div class="bg-light col-md-3 report_div">
                <h4>Declaration</h4>
                <h6>Inspector: </h6>
                <p>Bill Clinton</p>
                <h6>Status: </h6>
                <p class="text-info">Pending</p>
                <h6>Period from: </h6>
                <p>03 06 2018</p>
                <h6>Period to: </h6>
                <p>03 06 2018</p>
                <h6>Submission date </h6>
                <p>03 06 2018</p>
            </div>
            <div class="bg-light col-md-3 report_div">
                <h4>Message</h4>
                <h6>Inspector: </h6>
                <p>Bill Clinton</p>
                <h6>Status: </h6>
                <p class="text-success">Approved</p>
                <h6>Period from: </h6>
                <p>03 06 2018</p>
                <h6>Period to: </h6>
                <p>03 06 2018</p>
                <h6>Submission date </h6>
                <p>03 06 2018</p>
            </div>
            <div class="bg-light col-md-3 report_div">
                <h4>Declaration</h4>
                <h6>Inspector: </h6>
                <p>Bill Clinton</p>
                <h6>Status: </h6>
                <p class="text-danger">Rejected</p>
                <h6>Period from: </h6>
                <p>03 06 2018</p>
                <h6>Period to: </h6>
                <p>03 06 2018</p>
                <h6>Submission date </h6>
                <p>03 06 2018</p>
            </div>
            <div class="bg-light col-md-3 report_div">
                <h4>Declaration</h4>
                <h6>Inspector: </h6>
                <p>Bill Clinton</p>
                <h6>Status: </h6>
                <p class="text-info">Pending</p>
                <h6>Period from: </h6>
                <p>03 06 2018</p>
                <h6>Period to: </h6>
                <p>03 06 2018</p>
                <h6>Submission date </h6>
                <p>03 06 2018</p>
            </div>
            <div class="bg-light col-md-3 report_div">
                <h4>Declaration</h4>
                <h6>Inspector: </h6>
                <p>Bill Clinton</p>
                <h6>Status: </h6>
                <p class="text-info">Pending</p>
                <h6>Period from: </h6>
                <p>03 06 2018</p>
                <h6>Period to: </h6>
                <p>03 06 2018</p>
                <h6>Submission date </h6>
                <p>03 06 2018</p>
            </div>
            <div class="bg-light col-md-3 report_div">
                <h4>Declaration</h4>
                <h6>Inspector: </h6>
                <p>Bill Clinton</p>
                <h6>Status: </h6>
                <p class="text-info">Pending</p>
                <h6>Period from: </h6>
                <p>03 06 2018</p>
                <h6>Period to: </h6>
                <p>03 06 2018</p>
                <h6>Submission date </h6>
                <p>03 06 2018</p>
            </div>
            <div class="bg-light col-md-3 report_div">
                <h4>Declaration</h4>
                <h6>Inspector: </h6>
                <p>Bill Clinton</p>
                <h6>Status: </h6>
                <p class="text-info">Pending</p>
                <h6>Period from: </h6>
                <p>03 06 2018</p>
                <h6>Period to: </h6>
                <p>03 06 2018</p>
                <h6>Submission date </h6>
                <p>03 06 2018</p>
            </div>
        </div>
    </section>
</div>
</body>
</html>
