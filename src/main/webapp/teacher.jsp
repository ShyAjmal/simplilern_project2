<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href= "home.jsp">Home</a>
<br><br>
<form action="TeacherController" method ="post">
	 Enter  Name <input type ="text" name ="name" />

  <input type ="submit" value ="Add New Teacher"/>
</form>
<br><br><br><br>
<table style="background-color: #FFFFCC;border : 1px solid lightgray; width:300px;">
<thead style="text-align:center;border : 1px solid lightgray; ">
<tr style="text-align:center;border : 1px solid lightgray;  ">
<th >Name</th>
<th></th>
</tr>
</thead>
<tbody style="text-align:center; border : 1px solid lightgray;">
<c:forEach items="${teachers}" var="item">
<tr>
   <td> ${item.name}</td> 
    <td><a href="TeacherDetailsController?id=${item.id}">Details</a></td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>