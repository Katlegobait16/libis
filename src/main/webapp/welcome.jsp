<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:if test="${empty sessionScope.member}">
    <c:redirect url="/login.jsp"/>
</c:if>

<html>
<head>
    <title>LIBIS Catalogue</title>
</head>
<body>

    <h1>Welcome, <c:out value="${sessionScope.member.firstName}"/> <c:out value="${sessionScope.member.lastName}"/>!</h1>

    <table border="1">
        <tr>
            <th>#</th>
            <th>Title</th>
            <th>Author</th>
            <th>Genre</th>
            <th>Available</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="book" items="${sessionScope.books}" varStatus="st">
            <tr>
                <td><c:out value="${st.count}"/></td>
                <td><c:out value="${book.title}"/></td>
                <td><c:out value="${book.author}"/></td>
                <td><c:out value="${book.genre}"/></td>
                <td><c:out value="${book.available ? 'Yes' : 'No'}"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/book-view.jsp?id=${book.bookId}">View</a> |
                    <a href="${pageContext.request.contextPath}/book-edit.jsp?id=${book.bookId}">Edit</a> |

                    <form action="${pageContext.request.contextPath}/bookservlet" method="post"
                          style="display:inline"
                          onsubmit="return confirm('Delete this book? This cannot be undone.');">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="${book.bookId}">
                        <input type="submit" value="Delete">
                    </form> |

                    <a href="#">Search</a> |
                    <a href="#">Borrow</a> |
                    <a href="#">Reserve</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
