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
<a href= "home.jsp">Home</a> > Subjects
  <br/><br/>
<form action="SubjectController" method ="post">
	 Enter Subject Name:&nbsp;<input type ="text" name ="name" />
	  <br/>
	  Choose Class:&nbsp;
    <select name="department">
        <c:forEach items="${departments}" var="department">
            <option value="${department.id}">${department.name}</option>
        </c:forEach>
    </select>
    <br/>
    	  Choose Teacher:&nbsp;
    <select name="teacher">
        <c:forEach items="${teachers}" var="teacher">
            <option value="${teacher.id}">${teacher.name}</option>
        </c:forEach>
    </select>
    <br/>
  <input type ="submit" value ="Add New Subject"/>
</form>
  <br/><br/>
    <br/><br/>
<table style="background-color: #FFFFCC;border : 1px solid lightgray; width:300px;">
<thead style="text-align:center;border : 1px solid lightgray; ">
<tr style="text-align:center;border : 1px solid lightgray;  ">
<th >Subject</th>
<th>Class</th>
<th>Teacher</th>
</tr>
</thead>
<tbody  style="text-align:center; border : 1px solid lightgray;" >
<c:forEach items="${subjects}" var="item">
<tr>
   <td> ${item.name}</td> 
   <td> ${item.level.name} </td>
     <td> ${item.teacher.name} </td>
</tr>
</c:forEach>
</tbody>

</table>
</body>
</html>