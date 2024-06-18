<%@ page import="java.util.ArrayList" %>
<%@ page import="com.petshop.habernate.dao.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="d-flex justify-content-between align-items-center">
        <h1 class="my-4">CRUD sử dụng Hibernate và JPA.</h1>
        <from action="order-by-id" method="post">
            <button class="btn btn-success" type="submit">Sắp xếp theo ID</button>
        </from>
    </div>
    <table class="table table-bordered table-hover">
        <thead class="thead-dark">
        <tr class="text-center">
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<User> users = (ArrayList<User>) request.getAttribute("list-user");
            if (users != null) {
                for (User user1 : users) {
        %>
        <tr class="text-center">
            <td><%= user1.getId() %></td>
            <td><%= user1.getName() %></td>
            <td><%= user1.getEmail() %></td>
            <td><%= user1.getPassword() %></td>
            <td>
                <form action="update" method="post">
                    <input type="hidden" value="<%= user1.getId() %>" name="updateID">
                    <input type="hidden" value="<%= user1.getName() %>" name="updateName">
                    <input type="hidden" value="<%= user1.getEmail() %>" name="updateEmail">
                    <input type="hidden" value="<%= user1.getPassword() %>" name="updatePassword">
                    <button type="submit" class="btn btn-warning">Update</button>
                </form>
            </td>
            <td>
                <form action="delete" method="get">
                    <input type="hidden" value="<%= user1.getId() %>" name="delete">
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
    <h1 class="my-4">${Message == null ? "Handle Insert" : Message}</h1>
    <form action="${Message == null ? "insert" : "handle-update"}" method="post">
        <div class="form-group">
            <label for="id">ID</label>
            <input type="${ID_Update == null ? "text" : "hidden"}" class="form-control" name="id" value="${ID_Update == null ? "" : ID_Update}">
        </div>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" name="name" id="name" value="${Name_Update == null ? "" : Name_Update}">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" name="email" id="email" value="${Email_Update == null ? "" : Email_Update}">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="${Password_Update == null ? "password" : "text"}" class="form-control" name="password" id="password" value="${Password_Update == null ? "" : Password_Update}">
        </div>
        <button type="submit" class="btn btn-primary">${Message == null ? "Insert" : "Update"}</button>
    </form>
</div>
<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
