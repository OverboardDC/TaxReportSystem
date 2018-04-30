<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>AudioManager</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="wrapper">
    <header>
        <div class="row">
            <nav class="navbar bg-dark navbar-expand-md navbar-light col justify-content-between">
                <a href="#"><h1 class="text-light navbar-brand">Tax reporting system</h1></a>
                <div class="navbar-nav">
                    <a href="#" class="nav-item nav-link text-light">Create report</a>
                    <a href="#" class="nav-item nav-link text-light">My reports</a>
                    <a href="#" class="nav-item nav-link text-light">Help</a>
                    <a href="#" class="nav-item nav-link text-light">Login</a>

                    <select class="nav-item">
                        <option>English</option>
                        <option>Russian</option>
                    </select>
                </div>
            </nav>
        </div>
    </header>
    <section>
        <div class="row">
            <div class="text-center col-12">
                <h1>Welcome to the tax reports submission system!</h1>
                <img src="img/main_image.jpg" class="main_image">
                <h6>In order to create report, you need to sign in or sign up</h6>
                <div class="text-center col">
                    <a href="#">I already have account</a>
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
