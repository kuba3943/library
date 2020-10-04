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
<form action="/show">
    <div class="container mt-5">
        <div class="col-12">

            <a href="/show">
                <button type="submit" class="btn btn-dark" name="show" value="all">SHOW ALL</button>
            </a>
            <a href="/show">
                <button type="submit" class="btn btn-dark" name="show" value="ava">SHOW AVAILABLE</button>
            </a>

        </div>
    </div>
</form>

<jsp:include page="/WEB-INF/footer.jspf"/>
</body>
</html>
