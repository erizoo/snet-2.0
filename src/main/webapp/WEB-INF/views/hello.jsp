<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Hello Twitter</title>
</head>
<body>
<h3>Hello, <span th:text="${twitterProfile}">Some User</span>!</h3>

<h4>These are your friends:</h4>

<ul>
    <li th:each="friend:${friends}" th:text="${friend.name}">Friend</li>
</ul>
</body>
</html>