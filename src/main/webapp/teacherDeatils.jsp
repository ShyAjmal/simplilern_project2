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
<a href= "home.jsp">Home</a> > <a href= "TeacherController">Teacher</a> > ${teacher.name}
<h4>Subjects Assugned to Teacher ${teacher.name}</h4>


<table style="background-color: #FFFFCC;border : 1px solid lightgray; width:300px;">
<thead style="text-align:center;border : 1px solid lightgray; ">
<tr style="text-align:center;border : 1px solid lightgray;  ">
<th >Subject</th>
<th>Class</th>
</tr>
</thead>
<tbody  style="text-align:center; border : 1px solid lightgray;" >
 <c:forEach items="${teacherSubjectList}" var="item">
<tr>
   <td> ${item.name} </td> 
     <td> ${item.level.name} </td> 
</tr>
</c:forEach>
</tbody> 
</table>
</body>
</html>