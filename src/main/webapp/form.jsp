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
  <c:if test="${contact != null}">
   <form action="update" method="post">
        </c:if>
        <c:if test="${contact == null}">
   <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${contact != null}">
               Edit contact
              </c:if>
              <c:if test="${contact == null}">
               Add New contact
              </c:if>
             </h2>
            </caption>
          <c:if test="${contact != null}">
           <input type="hidden" name="id" value="<c:out value='${contact.id}' />" />
          </c:if>            
            <tr>
                <th>contact Name: </th>
                <td>
                 <input type="text" name="name" size="45"
                   value="<c:out value='${contact.name}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>contact Email: </th>
                <td>
                 <input type="text" name="email" size="45"
                   value="<c:out value='${contact.email}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Country: </th>
                <td>
                 <input type="text" name="address" size="15"
                   value="<c:out value='${contact.address}' />"
                 />
                </td>
            </tr>
             <tr>
                <th>Country: </th>
                <td>
                 <input type="text" name="phone" size="15"
                   value="<c:out value='${contact.phone}' />"
                 />
                </td>
            </tr>
            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Save" />
             </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
</html>