<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="language" scope="session" value="${empty sessionScope.lang ? 'en_US' : sessionScope.lang}"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="messages" var="bundle" scope="session"/>
