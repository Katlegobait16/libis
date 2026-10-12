<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>LIBIS Login</title>
</head>
<body>
    <h1>LIBIS Member Login</h1>

    <p style="color:red;">${errorMessage}</p>

    <form action="${pageContext.request.contextPath}/process-login" method="post">
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" required><br><br>

        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" required><br><br>

        <input type="submit" value="Login">
    </form>

    <p>New here? <a href="${pageContext.request.contextPath}/signup.jsp">Sign up</a></p>
</body>
</html>