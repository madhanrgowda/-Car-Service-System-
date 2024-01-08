<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="padding-top: 100px; background-color: skyblue;">
<center>
Welcome  <%out.println(session.getAttribute("cname"));%>
<h1>Will you update the car Details</h1>
<a href="/CarService/updateDetails.html">Update Details</a>
<br>

<h1>Check Car Details</h1>
<a href="/CarService/CarCheck">Car Details</a>
</center>

</body>
</html>