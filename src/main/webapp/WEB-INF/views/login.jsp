<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: akhambir
  Date: 1/11/18
  Time: 9:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">
</head>

<body>

<div class="container">

    <spring:form class="form-signin" action="/login" id="loginform" method="post" modelAttribute="user">
        <h2 class="form-signin-heading">Please sign in</h2>
        <spring:label path="email" class="sr-only">Email address</spring:label>
        <spring:input type="email"  path="email" class="form-control" placeholder="Email address" required="true" autofocus="true"/>
        <spring:label path="password" class="sr-only">Password</spring:label>
        <spring:input type="password" class="form-control" path="password" placeholder="Password" required="true"/>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </spring:form>

</div> <!-- /container -->
</body>
</html>
