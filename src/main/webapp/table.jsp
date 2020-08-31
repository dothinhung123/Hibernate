<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>contact Management Application</title>
</head>
<body>
 <center>
  <h1>contact Management</h1>
        <h2>
         <a href="add">Add New contact</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All contacts</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of contacts</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="contact" items="${contacts}">
                <tr>
                    <td><c:out value="${contact.id}" /></td>
                    <td><c:out value="${contact.name}" /></td>
                    <td><c:out value="${contact.email}" /></td>
                    <td><c:out value="${contact.address}" /></td>
                    <td><c:out value="${contact.phone}" /></td>
                    <td>
                     <a href="edit?id=<c:out value='${contact.id}' />">Edit</a>
                    
                     <a href="delete?id=<c:out value='${contact.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>