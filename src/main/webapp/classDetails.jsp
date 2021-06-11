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
<h4>${level.name} Report</h4>
<br><br>



<table style="background-color: #FFFFCC;border : 1px solid lightgray; width:300px;">
<thead style="text-align:center;border : 1px solid lightgray; ">
<tr style="text-align:center;border : 1px solid lightgray;  ">
<th >Subject</th>
<th>Teacher</th>
</tr>
</thead>
<tbody  style="text-align:center; border : 1px solid lightgray;" >
 <c:forEach items="${subjects}" var="item">
<tr >
   <td> ${item.name} </td> 

   <td> ${item.teacher.name}</td> 
</tr>
</c:forEach> 
</tbody>
</table>
<br><br>
<table style="background-color: #FFFFCC;border : 1px solid lightgray; width:300px;">
<thead style="text-align:center;border : 1px solid lightgray; ">
<tr style="text-align:center;border : 1px solid lightgray;  ">
<th >Students</th>

</tr>
</thead>
<tbody  style="text-align:center; border : 1px solid lightgray;" >
 <c:forEach items="${students}" var="student">
<tr >
   <td> ${student.name} </td> 
</tr>



</c:forEach> 
</tbody>
</table>
</body>
</html>