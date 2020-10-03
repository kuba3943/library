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
    <title>SHOW</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/WEB-INF/header.jspf"/>

<form action="/red">
<table class="table">
    <thead class="thead-dark">

    <tr>

        <th scope="col">#</th>
        <th scope="col">Title</th>
        <th scope="col">Category</th>
        <th scope="col">Author</th>
        <th scope="col">Borrow</th>
        <th scope="col">Choose</th>
    </tr>
    </thead>
    <c:forEach var="book" items="${requestScope.listOfBooks}">
    <tbody>

    <tr>

        <th scope="row"><c:out value="${book.id}"/></th>

        <td><c:out value="${book.title}"/></td>

        <td><c:out value="${book.category}"/></td>

        <td><c:out value="${book.authorId.lastName}"/></td>

        <td><c:out value="${book.borrow}"/></td>
        <td>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="${book.id}"
                       checked>
                <label class="form-check-label" for="exampleRadios1">
                </label>
            </div>
        </td>
    </tr>


    </c:forEach>
    </tbody>
</table>
    <a href="/red"> <button type="submit" class="btn btn-primary" name="details">DETAILS</button></a>
    <a href="/red"> <button type="submit" class="btn btn-primary" name="delete">DELETE</button></a>
</form>

<br>

<jsp:include page="/WEB-INF/footer.jspf"/>
</body>
</html>
