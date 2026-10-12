<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:if test="${empty sessionScope.member}">
    <c:redirect url="/login.jsp"/>
</c:if>

<html>
<head>
    <title>Book details</title>
</head>
<body>

    <c:set var="found" value="no"/>

    <c:forEach var="book" items="${sessionScope.books}">
        <c:if test="${book.bookId == param.id}">
            <c:set var="found" value="yes"/>

            <h1><c:out value="${book.title}"/></h1>

            <table border="1">
                <tr><th>Author</th><td><c:out value="${book.author}"/></td></tr>
                <tr><th>Genre</th><td><c:out value="${book.genre}"/></td></tr>
                <tr><th>Available</th><td><c:out value="${book.available ? 'Yes' : 'No'}"/></td></tr>
                <tr><th>Synopsis</th><td><c:out value="${book.synopsis}"/></td></tr>
            </table>
        </c:if>
    </c:forEach>

    <c:if test="${found == 'no'}">
        <p>That book could not be found.</p>
    </c:if>

    <p><a href="${pageContext.request.contextPath}/welcome.jsp">Back to the catalogue</a></p>

</body>
</html>