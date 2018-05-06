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
            <h1><fmt:message key="requests" bundle="${bundle}"/></h1>
        </div>
        <div class="row justify-content-start">
            <c:forEach var="request" items="${requestScope.requests}">
                <div class="bg-light admin_page_item col-md-3">
                    <div class="form-group">
                        <h4>${request.taxPayer.firstName} ${request.taxPayer.lastName}</h4>
                        <h6><fmt:message key="username.in" bundle="${bundle}"/> ${request.taxPayer.username}</h6>
                        <h6><fmt:message key="identification.code.in"
                                         bundle="${bundle}"/> ${request.taxPayer.identificationCode}</h6>
                        <h6><fmt:message key="inspector.in"
                                         bundle="${bundle}"/> ${request.inspector.firstName} ${request.inspector.lastName}</h6>
                        <h6><fmt:message key="reason.in" bundle="${bundle}"/></h6>
                        <p>${request.reason}</p>
                        <form>
                            <div class="form-group">
                                <label><fmt:message key="choose.new.inspector" bundle="${bundle}"/></label>
                                <select class="input-group">
                                    <option selected disabled class="hidden"><fmt:message key="select"
                                                                                          bundle="${bundle}"/></option>
                                    <c:forEach items="${requestScope.inspectors}" var="inspector">
                                        <option>${inspector.firstName} ${inspector.lastName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <button class="btn bg-success text-light"><fmt:message key="accept"
                                                                                   bundle="${bundle}"/></button>
                        </form>

                        <form>
                            <div class="form-group">
                                <label><fmt:message key="reason.in" bundle="${bundle}"/></label>
                                <textarea placeholder="Reason" name="reason" class="input-group"></textarea>
                            </div>
                            <button class="btn bg-danger text-light"><fmt:message key="reject"
                                                                                  bundle="${bundle}"/></button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </section>
</div>
</body>
</html>
