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
            <h4 class="alert-heading"><c:out value="${requestScope.book.title}"/></h4>
            <hr>
            <p>SUMMARY: <c:out value="${requestScope.book.summary}"/></p>
            <hr>
            <p class="mb-0">ISBN: <c:out value="${requestScope.book.isbn}"/></p>
            <hr>
            <p class="mb-0">AUTHOR: <c:out value="${requestScope.book.authorFirstName}"/> <c:out value="${requestScope.book.authorLastName}"/></p>
            <hr>
            <p class="mb-0">PAGES: <c:out value="${requestScope.book.pages}"/></p>
            <hr>
            <p class="mb-0">BORROWER: <c:out value="${requestScope.borrower.lastName}"/></p>
        </div>

    </div>



    <div class="container mt-5">
        <div class="col-12">
            <form action="/detRed">
                <button type="submit" class="btn btn-light" name="action" value="${requestScope.book.id}">SHOW BORROW HISTORY</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jspf"/>
</body>
</html>
