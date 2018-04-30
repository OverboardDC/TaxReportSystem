<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../template/head.jsp"/>
<body>
<div class="wrapper">
    <jsp:include page="../template/header.jsp"/>
    <section>
        <div class="row justify-content-center">

            <form class="form-group col-md-4">
                <h1 class="text-center">Registration</h1>
                <label>Choose the person type</label>
                <select id="client_type_select" class="nav-item input-group" title="Option" required>
                    <option selected disabled class="hidden">Select</option>
                    <option id="individual">Individual</option>
                    <option id="company">Company</option>
                </select>
                <div id="individual_items" class="hidden">
                    <label>First name:</label>
                    <input class="input-group" name="first_name">

                    <label>Last name:</label>
                    <input class="input-group" name="last_name">

                    <label>Identification code:</label>
                    <input class="input-group" name="identification_code">
                </div>
                <div id="company_items" class="hidden">
                    <label>Name:</label>
                    <input class="input-group" name="company_name">
                </div>
                <div id="items_for_all" >

                    <label>Username:</label>
                    <input class="input-group" name="username">

                    <label>Password:</label>
                    <input class="input-group" name="password">

                    <label>Repeat the password:</label>
                    <input class="input-group" name="password_repeat">

                    <button class="btn btn-success">Submit</button>
                </div>

            </form>
        </div>
    </section>
</div>
<script rel="script" src="<c:url value="/resources/js/jquery.js"/>"></script>
<script rel="script" src="<c:url value="/resources/js/script.js"/>"></script>
</body>


</html>
