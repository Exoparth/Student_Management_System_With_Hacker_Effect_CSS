<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ty.Student" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Student Details</title>
    <link rel="stylesheet" type="text/css" href="personaldetails.css">
</head>

<body>
    <div class="student-details-card">
        <h2>Student Details</h2>
		
		<% 
        
        String uname = (String) session.getAttribute("uname"); 
    	%>
       
		
        <p><strong>Name:</strong> ${uname}</p>
        <p><strong>Email:</strong> ${uemail}</p>
        <p><strong>Phone:</strong> ${uphone}</p>
        <p><strong>Std:</strong> ${ustd}</p>
	    <div style="margin-top: 20px;">
	    
	        <button onclick="window.location.href='dashboard.jsp'" class="animated-button">Back</button>
	    </div>
    </div>
    
   
</body>
</html>
