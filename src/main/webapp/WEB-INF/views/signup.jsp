<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <style>
        .error {
            color: #ff0000;
        }

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>

<body>

    <div class="container">

        <form:form class="form-signin" action="/signup" method="post" modelAttribute="user">
            <form:errors path="*" cssClass="errorblock" element="div" />
            <h2 class="form-signin-heading">Registration</h2>
            <form:label path="email" class="sr-only">Email address</form:label>
            <form:input type="email"  path="email" class="form-control" placeholder="Email address" required="true" autofocus="true"/>
            <form:errors path="email" cssClass="error" />
            <form:label path="password" class="sr-only">Password</form:label>
            <form:input type="password" class="form-control" path="password" placeholder="Password" required="true"/>
            <form:errors path="password" cssClass="error" />
            <%--<spring:label path="password" class="sr-only">Password</spring:label>
            <spring:input type="password" class="form-control" path="password" placeholder="Password" required="true"/>--%>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form:form>

    </div>

    <script>



    </script>
</body>
</html>
