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
    <title>ADD</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/WEB-INF/header.jspf"/>
<div class="container mt-5">
    <div class="col-12">
        <form action="/editServlet">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="title">Title</label>
                    <input type="text" class="form-control" id="title" name="title" value="${requestScope.book.title}" placeholder="Title">
                </div>
                <div class="form-group col-md-6">
                    <label for="isbn">ISBN</label>
                    <input type="text" class="form-control" id="isbn" name="isbn" value="${requestScope.book.isbn}" placeholder="ISBN">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="author">Author</label>
                    <select id="author" class="form-control" name="author">


                        <option value="${requestScope.author2.id}" ><c:out value="${requestScope.author2.firstName} ${requestScope.author2.lastName}"/></option>
                        <c:forEach var="author" items="${requestScope.authors}">

                            <option value="${author.id}"><c:out
                                    value="${author.firstName} ${author.lastName}"/></option>

                        </c:forEach>

                    </select>
                </div>
                <div class="form-group col-md-6">
                    <label for="category">Category</label>
                    <select id="category" class="form-control" name="category">


                        <option value="${requestScope.book.category}">  ${requestScope.book.category.name()}</option>
                        <c:forEach var="cat" items="${requestScope.categories}">

                            <option value="${cat}"><c:out
                                    value="${cat.name()}"/></option>

                        </c:forEach>

                    </select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="page">Pages</label>
                    <input type="number" class="form-control" id="page" name="page" value="${requestScope.book.pages}">
                </div>
                <div class="form-group col-md-6">
                    <label for="date">Date</label>
                    <input type="date" class="form-control" id="date" name="date" value="${requestScope.book.releaseDate}">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="summary">Summary</label>
                    <textarea class="form-control" id="summary" rows="3" name="summary" value="${requestScope.book.summary}">${requestScope.book.summary}</textarea>
                </div>
            </div>
            <br>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="borrow" id="exampleRadios2" value="0" checked>
                <label class="form-check-label" for="exampleRadios2" value="0">
                    TO BORROW
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="borrow" id="exampleRadios3" value="1">
                <label class="form-check-label" for="exampleRadios3" value="1">
                    BORROWED
                </label>
            </div>
            <br>
            <button type="submit" class="btn btn-primary" name="id" value="${requestScope.id}">EDIT</button>
        </form>

        <div class="container mt-5">
            <div class="col-12">
                <form action="/addRed">
                    <button type="submit" class="btn btn-light" name="action" value="back">BACK</button>
                    <button type="submit" class="btn btn-light" name="action" value="aut">ADD AUTHOR</button>
                </form>
            </div>
        </div>


    </div>
</div>


<jsp:include page="/WEB-INF/footer.jspf"/>
</body>
</html>
