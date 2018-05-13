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
            <h1><fmt:message key="admin.page" bundle="${bundle}"/></h1>
        </div>
        <div class="row justify-content-between">
            <div class="col-md-3">
                <a href="<c:url value="/app/admin/allRequests"/>" class="btn btn-success"><fmt:message key="view.requests" bundle="${bundle}"/></a>
            </div>
        </div>
        <h3 class="text-center"><fmt:message key="new.users" bundle="${bundle}"/></h3>
        <h6 class="text-danger">${sessionScope.admin_page_error}</h6>
        <c:remove var="admin_page_error" scope="session"/>
        <div class="row justify-content-start">
            <c:forEach var="tax_payer" items="${requestScope.tax_payers}">
                <div class="bg-light item">
                    <form method="post" action="<c:url value="/app/redirect/admin/assignInspector"/>">
                        <h4>${tax_payer.firstName} ${tax_payer.lastName}</h4>
                        <h6><fmt:message key="username.in" bundle="${bundle}"/> ${tax_payer.username}</h6>
                        <h6><fmt:message key="identification.code.in"
                                         bundle="${bundle}"/> ${tax_payer.identificationCode}</h6>

                        <label><fmt:message key="assign.inspector" bundle="${bundle}"/></label>
                        <select name="inspector_id">
                            <option selected disabled class="hidden"><fmt:message key="select"
                                                                                  bundle="${bundle}"/></option>
                            <c:forEach var="inspector" items="${requestScope.inspectors}">
                                <option value="${inspector.id}">${inspector.firstName} ${inspector.lastName}</option>
                            </c:forEach>
                        </select>
                        <input value="${tax_payer.id}" type="hidden" name="tax_payer_id">
                        <button class="btn bg-primary text-light"><fmt:message key="assign"
                                                                               bundle="${bundle}"/></button>
                    </form>
                </div>
            </c:forEach>
        </div>
    </section>
</div>
</body>
</html>
