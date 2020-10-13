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
    <title>BORROW</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/WEB-INF/header.jspf"/>
<div class="container mt-5">
    <div class="col-12">
        <form action="/borrowServlet">
            <div class="form-group col-md-12">
                <label for="borrower">Borrowers</label>
                <select id="borrower" class="form-control" name="borrower">


                    <c:forEach var="borrower" items="${requestScope.borrowers}">

                        <option value="${borrower.id}"><c:out
                                value="${borrower.firstName} ${borrower.lastName}"/></option>

                    </c:forEach>

                </select>
            </div>

            <br>
            <button type="submit" class="btn btn-primary" name="id" value="${requestScope.book.id}">BORROW</button>
        </form>

        <div class="container mt-5">
            <div class="col-12">
                <form action="index.jsp">
                    <button type="submit" class="btn btn-light" name="action" value="back">BACK</button>
                </form>
            </div>
        </div>


    </div>
</div>


<jsp:include page="/WEB-INF/footer.jspf"/>
</body>
</html>
