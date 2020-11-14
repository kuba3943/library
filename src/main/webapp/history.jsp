<%--
  Created by IntelliJ IDEA.
  User: Jakub Domagała
  Date: 27.09.2020
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>DETAILS</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/WEB-INF/header.jspf"/>
<div class="container mt-5">
    <div class="col-12">


        <div class="alert alert-success" role="alert">
            <c:forEach var="hb" items="${requestScope.historyOfBorrows}">
                <c:out value="${hb.borrowerId.firstName}"/>
                <c:out value="${hb.borrowerId.lastName}"/>
                <c:out value="${hb.rentalDate}"/>
                <br>
            </c:forEach>
        </div>

    </div>


</div>
<jsp:include page="/WEB-INF/footer.jspf"/>
</body>
</html>
