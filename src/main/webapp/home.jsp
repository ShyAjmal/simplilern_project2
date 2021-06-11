<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
HttpSession loginSession = request.getSession(false);

out.println("<h1>Wecome "+session.getAttribute("user")+"</h1>"); 
%>
<a href="ClassContorller">Class</a> <br><br>
<a href="StundentController">Student</a> <br><br>
<a href="TeacherController">Teacher</a> <br><br>
<a href="SubjectController">Subject</a> <br><br>
</body>
</html>