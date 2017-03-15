<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:url value="/sign" var="signIn" />
<form action="${signIn}" method="post">
    <input type="text" class="form-control" name="pin_code" placeholder="Enter the PIN-code"><br>
    <button class="btn btn-social btn-twitter" type="submit">Sign in with Twitter</button></form>
</body>
</html>
