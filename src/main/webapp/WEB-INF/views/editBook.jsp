<%--
  Created by IntelliJ IDEA.
  User: griegoriens
  Date: 21.01.2023
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit add</title>
</head>
<body>

    <c:url var="edit_url" value="/admin/books/edit"/>
    <form:form method="post" modelAttribute="book" action="${edit_url}">
    <form:hidden path="id"/>
    <labeL>ISBN
        <form:input path="isbn"/>
        <form:errors path="isbn"/><br/>
    </labeL>
    <labeL>Title
        <form:input path="title"/>
        <form:errors path="title"/><br/>
    </labeL>
    <label>Author
        <form:input path="author"/>
        <form:errors path="author"/><br/>
    </label>
    <label>Publisher
        <form:input path="publisher"/>
        <form:errors path="publisher"/><br/>
    </label>
    <label>Type
        <form:input path="type"/>
        <form:errors path="type"/><br/>
    </label>

    <input type="submit" value="Save">
</form:form>
</body>
</html>