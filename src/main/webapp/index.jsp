<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>HOMAPAGE</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
<jsp:include page="/WEB-INF/header.jspf"/>

<br>
<c:forEach var="book" items="${sessionScope.listOfBooks}">
    <c:out value="${book.title}"/>
    <br>
</c:forEach>
<br>


<jsp:include page="/WEB-INF/footer.jspf"/>
</body>
</html>
