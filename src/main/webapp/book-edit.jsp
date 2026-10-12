<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:if test="${empty sessionScope.member}">
    <c:redirect url="/login.jsp"/>
</c:if>

<html>
<head>
    <title>Edit book</title>
</head>
<body>

    <h1>Edit book</h1>

    <c:set var="found" value="no"/>

    <c:forEach var="book" items="${sessionScope.books}">
        <c:if test="${book.bookId == param.id}">
            <c:set var="found" value="yes"/>

            <form action="${pageContext.request.contextPath}/bookservlet" method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" value="${book.bookId}">

                Title: <input type="text" name="title" value="<c:out value='${book.title}'/>" required><br><br>
                Author: <input type="text" name="author" value="<c:out value='${book.author}'/>" required><br><br>
                Genre: <input type="text" name="genre" value="<c:out value='${book.genre}'/>" required><br><br>
                Synopsis:<br>
                <textarea name="synopsis" rows="4" cols="50"><c:out value="${book.synopsis}"/></textarea><br><br>
                <label>
                    <input type="checkbox" name="available" value="yes" <c:if test="${book.available}">checked</c:if>>
                    Available
                </label><br><br>

                <input type="submit" value="Save changes">
            </form>
        </c:if>
    </c:forEach>

    <c:if test="${found == 'no'}">
        <p>That book could not be found.</p>
    </c:if>

    <p><a href="${pageContext.request.contextPath}/welcome.jsp">Cancel, back to the catalogue</a></p>

</body>
</html>
