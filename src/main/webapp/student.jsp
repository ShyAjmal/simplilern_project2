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
<form action="StundentController" method ="post">
	Enter name: <input type ="text" name ="name" /> <br>
	  Choose Class:&nbsp;
	 
    <select name="department">
        <c:forEach items="${departments}" var="department">
            <option value="${department.id}">${department.name}</option>
        </c:forEach>
    </select>
    <br/>
  <input type ="submit" value ="Add New Student"/>
</form>
 <br> <br>
<table style="background-color: #FFFFCC;border : 1px solid lightgray; width:300px;">
<thead style="text-align:center;border : 1px solid lightgray; ">
<tr style="text-align:center;border : 1px solid lightgray;  ">
<th >Name</th>
<th>Class</th>
</tr>
</thead>
<tbody  style="text-align:center; border : 1px solid lightgray;" >
<c:forEach items="${students}" var="item">
<tr>
   <td> ${item.name}</td> 
   <td> ${item.level.name} </td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>