<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29.04.2018
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header>
    <div class="row">
        <nav class="navbar bg-dark navbar-expand-md navbar-light col justify-content-between">
            <a href="<c:url value="/app/homePage"/>"><h1 class="text-light navbar-brand">Tax reporting system</h1></a>
            <div class="navbar-nav">
                <a href="#" class="nav-item nav-link text-light">Create report</a>
                <a href="#" class="nav-item nav-link text-light">My reports</a>
                <a href="#" class="nav-item nav-link text-light">Help</a>
                <a href="<c:url value="/app/loginPage"/>" class="nav-item nav-link text-light">Login</a>

                <select class="nav-item">
                    <option>English</option>
                    <option>Russian</option>
                </select>
            </div>
        </nav>
    </div>
</header>
