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
    <title>ADD AUTHOR</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/WEB-INF/header.jspf"/>
<div class="container mt-5">
    <div class="col-12">
        <form action="/addAuthorServlet">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="first">First Name</label>
                    <input type="text" class="form-control" id="first" name="first" value="" placeholder="First Name">
                </div>
                <div class="form-group col-md-6">
                    <label for="last">Last Name</label>
                    <input type="text" class="form-control" id="last" name="last" value="" placeholder="Last Name">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="place">Birth Place</label>
                    <input type="text" class="form-control" id="place" name="place" value="" placeholder="Birth Place">
                </div>
            </div>
            <br>
            <button type="submit" class="btn btn-primary">ADD</button>
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
