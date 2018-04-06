<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: akhambir
  Date: 1/27/18
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>

    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body>

    <div class="container ml-5">
        <div>
            <h1>Category: ${category.name}</h1>
        </div>
        <div>
            <h3>Description: ${category.description}</h3>
        </div>
        <div>
            <h3>Products: </h3>
            <div>
                <c:forEach var="p" items="${category.products}">
                    <a href="<c:url value="/product/get/${p.id}"/>"><h3>${p.productName}</h3></a>
                </c:forEach>
            </div>
        </div>
    </div>

</body>
</html>
