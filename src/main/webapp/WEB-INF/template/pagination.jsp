<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row justify-content-center">
    <ul class="pagination">
        <c:forEach var="page" items="${requestScope.pages}">
            <c:url value="" var="changePage">
                <c:param name="page" value="${page.number}"/>
            </c:url>
            <c:if test="${not page.selected}">
                <li class="page-item"><a class="page-link badge-light" href="${changePage}">${page.number}</a></li>
            </c:if>
            <c:if test="${page.selected}">
                <li class="page-item"><a class="page-link badge-dark" href="${changePage}">${page.number}</a></li>
            </c:if>
        </c:forEach>
    </ul>
</div>

