<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../../template/head.jsp"/>
<body>

<div class="wrapper">
    <jsp:include page="../../template/header.jsp"/>
    <section>
        <div class="row justify-content-center">

            <form class="form-group col-lg-4" method="post" action="<c:url value="/app/redirect/client/sendReport"/>">
                <h1 class="text-center"><fmt:message key="adding.new.report" bundle="${bundle}"/></h1>
                <h6 class="text-danger">${sessionScope.new_report_error}</h6>
                <c:remove var="new_report_error" scope="session"/>
                <div class="form-group">

                    <label><fmt:message key="period.from" bundle="${bundle}"/>:</label>
                    <h6 class="text-danger">${sessionScope.period_from_error}</h6>
                    <c:remove var="period_from_error" scope="session"/>
                    <input type="date" class="input-group" name="period_from">

                    <label><fmt:message key="period.to" bundle="${bundle}"/>:</label>
                    <h6 class="text-danger">${sessionScope.period_to_error}</h6>
                    <c:remove var="period_to_error" scope="session"/>
                    <input type="date" class="input-group" name="period_to">

                    <label><fmt:message key="revenue" bundle="${bundle}"/>:</label>
                    <h6 class="text-danger">${sessionScope.revenue_error}</h6>
                    <c:remove var="revenue_error" scope="session"/>
                    <input type="text" name="revenue" class="input-group">

                    <label><fmt:message key="tax" bundle="${bundle}"/>:</label>
                    <h6 class="text-danger">${sessionScope.tax_error}</h6>
                    <c:remove var="tax_error" scope="session"/>
                    <input type="text" name="tax" class="input-group">

                    <label><fmt:message key="commentary" bundle="${bundle}"/>:</label>
                    <h6 class="text-danger">${sessionScope.commentary_error}</h6>
                    <c:remove var="commentary_error" scope="session"/>
                    <textarea name="commentary" class="input-group"></textarea>
                </div>

                <input name="tax_payer_id" hidden value="${sessionScope.user.id}">
                <input name="inspector_id" hidden value="${requestScope.inspector.id}">
                <button class="btn btn-success"><fmt:message key="submit" bundle="${bundle}"/></button>
                <button type="reset" class="btn btn-danger"><fmt:message key="reset" bundle="${bundle}"/></button>
            </form>
        </div>
    </section>
</div>
</body>
</html>
