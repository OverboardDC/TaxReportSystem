<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ct" uri="/WEB-INF/tag/customTags.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../../template/head.jsp"/>
<body>

<div class="wrapper">
    <jsp:include page="../../template/header.jsp"/>
    <section>
        <div class="row justify-content-center">

            <form class="form-group col-4" method="post" action="<c:url value="/app/redirect/client/editReport"/>">
                <h1 class="text-center"><fmt:message key="adding.new.report" bundle="${bundle}"/></h1>
                <div class="form-group">

                    <h6 class="text-danger">${sessionScope.period_from_error}</h6>
                    <c:remove var="period_from_error" scope="session"/>
                    <label><fmt:message key="period.from" bundle="${bundle}"/>:</label>
                    <input type="date" class="input-group" name="period_from"
                           value="${requestScope.report.periodFrom}" required>

                    <h6 class="text-danger">${sessionScope.period_to_error}</h6>
                    <c:remove var="period_to_error" scope="session"/>
                    <label><fmt:message key="period.to" bundle="${bundle}"/>:</label>
                    <input type="date" class="input-group" name="period_to"
                           value="${requestScope.report.periodTo}" required>

                    <h6 class="text-danger">${sessionScope.revenue_error}</h6>
                    <c:remove var="revenue_error" scope="session"/>
                    <label><fmt:message key="revenue" bundle="${bundle}"/>:</label>
                    <input type="text" name="revenue" class="input-group"
                           value="<ct:formatRevenue revenue="${requestScope.report.revenue}"/>" required>

                    <h6 class="text-danger">${sessionScope.tax_error}</h6>
                    <c:remove var="tax_error" scope="session"/>
                    <label><fmt:message key="tax" bundle="${bundle}"/>:</label>
                    <input type="text" name="tax" class="input-group" value="<ct:formatTax tax="${requestScope.report.tax}"/>" required>

                    <h6 class="text-danger">${sessionScope.commentary_error}</h6>
                    <c:remove var="commentary_error" scope="session"/>
                    <label><fmt:message key="commentary" bundle="${bundle}"/>:</label>
                    <textarea name="commentary" class="input-group">${requestScope.report.commentary}</textarea>
                </div>

                <input hidden name="report_id" value="${requestScope.report.id}">
                <input name="inspector_id" hidden value="${requestScope.inspector.id}">
                <input name="tax_payer_id" hidden value="${requestScope.taxpayer.id}">
                <button class="btn btn-success"><fmt:message key="submit" bundle="${bundle}"/></button>
                <button type="reset" class="btn btn-danger"><fmt:message key="reset" bundle="${bundle}"/></button>
            </form>
        </div>
    </section>
</div>
</body>
</html>
