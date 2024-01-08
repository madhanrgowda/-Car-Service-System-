<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="padding-top: 100px; background-color: skyblue; font-size: 30px">
<center>
<br>
Hi <%out.println(session.getAttribute("cname")); %><br>
Here is the car details<br>
<% out.println("Car name :"+session.getAttribute("cname")); %><br> 
<%out.println("Car type :"+session.getAttribute("mtype")); %><br> 
<%out.println("Car reg num :"+session.getAttribute("carnum"));%><br> 
</center>
</body>
</html>