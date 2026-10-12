<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>LIBIS Sign Up</title>
</head>
<body>
    <h1>Sign Up</h1>

    <p style="color:red;">${errorMessage}</p>

    <form action="${pageContext.request.contextPath}/process-signup" method="post">
        First Name: <input type="text" name="firstName" required><br>
        Last Name: <input type="text" name="lastName" required><br>
        Email: <input type="email" name="email" required><br>
        Password: <input type="password" name="password" required><br>
        <input type="submit" value="Create Account">
    </form>

    <p><a href="${pageContext.request.contextPath}/login.jsp">Back to login</a></p>
</body>
</html>