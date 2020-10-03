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

<div class="container mt-5">
    <div class="col-6">

<a href="details.jsp"> <button type="button" class="btn btn-primary">ADD</button></a>
<a href="/show"> <button type="button" class="btn btn-success">SHOW ALL</button></a>

    </div>
</div>


<jsp:include page="/WEB-INF/footer.jspf"/>
</body>
</html>
