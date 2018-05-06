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
                <a href="#" class="btn btn-success">View requests</a>
            </div>
        </div>
        <h3 class="text-center">New users</h3>
        <div class="row justify-content-start">
            <c:forEach var="tax_payer" items="${requestScope.tax_payers}">
                <div class="bg-light admin_page_item">
                    <h4>${tax_payer.firstName} ${tax_payer.lastName}</h4>
                    <h6>Username: ${tax_payer.username}</h6>
                    <h6>Identification_code: ${tax_payer.identificationCode}</h6>
                    <form>
                        <select>
                            <option>Bill Clinton</option>
                            <option>Donald Trump</option>
                        </select>
                        <button class="btn bg-primary text-light">Pick</button>
                    </form>
                </div>
            </c:forEach>
        </div>
    </section>
</div>
</body>
</html>
