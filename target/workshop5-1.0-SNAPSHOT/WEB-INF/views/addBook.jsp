<%--
  Created by IntelliJ IDEA.
  User: griegoriens
  Date: 10.01.2023
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>I am genius</title>
</head>
<body>
  <form action="/books/addNewBook" method="POST">
    <label>
      Podaj id książki
      <input type="number" name="id">
    </label></br>

    <label>
      Podaj numer ISBN
      <input type="text" name="isbn">
    </label></br>

    <label>
      Podaj tytuł książki
      <input type="text" name="title">
    </label></br>

    <label>
      Podaj imię i nazwisko autora
      <input type="text" name="author">
    </label></br>

    <label>
      Podaj wydawcę
      <input type="text" name="publisher">
    </label></br>

    <label>
      Podaj kategorię
      <input type="text" name="type">
    </label></br>
    <button type="submit">Dodaj książkę do bazy</button>
  </form>
  <form method="GET" action="/books/removeBook">
    <label>
      <input name="id">
    </label>
    <button type="submit">Usuń książkę z bazy</button>
  </form>
</body>
</html>
