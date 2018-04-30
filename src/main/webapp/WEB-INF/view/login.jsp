<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../template/head.jsp"/>
<body>
<div class="wrapper">
    <jsp:include page="../template/header.jsp"/>
    <section>
        <div class="row">
            <div class="text-center col-12">
                <h1>Welcome to the tax reports submission system!</h1>
                <img src="<c:url value="/resources/img/main_image.jpg"/>" class="main_image">
                <h6>In order to create report, you need to sign in or sign up</h6>
                <div class="text-center col">

                </div>
                <div class="text-center col">
                    <a href="#">I am a new user</a>
                </div>

            </div>
            <div class="col">

            </div>
        </div>
    </section>
</div>
</body>
</html>
