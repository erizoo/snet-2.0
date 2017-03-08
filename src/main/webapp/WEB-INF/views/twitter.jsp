<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hello Twitter</title>
</head>
<body>
<h3>Connect to Twitter</h3>

<form action="<c:url value="/connect/twitter"/>">
    <div class="formInfo">
        <p>You aren't connected to Twitter yet. Click the button to connect this application with your Twitter account.</p>
    </div>
    <p><button type="submit">Connect to Twitter</button></p>
</form>
</body>
</html>