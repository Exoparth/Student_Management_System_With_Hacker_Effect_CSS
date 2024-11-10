<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@ page import="javax.servlet.http.HttpSession" %>   
<%@ page import="com.ty.Login" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="dashboard.css">
</head>
<body>
    <div class="container">
        <h2>${msg}</h2>
        <% 
		   response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		   response.setHeader("Pragma", "no-cache");
		   response.setDateHeader("Expires", 0);
		%>
         <% 
        
        String uname = (String) request.getSession().getAttribute("uname"); 
   		 %>
       
        <div class="scrolling-text">
            <h2>Welcome: ${uname}</h2>
        </div>

        
        <form action="DetailsServlet" method="post">
            <input type="submit" value="Show Details" class="animated-button">
        </form>

        
        <a href="update.jsp" class="animated-link">Update Details</a>

        <!-- Delete Form -->
        <form action="DeleteRecord">
            <input type="submit" value="Delete Student" class="animated-button">
        </form>
    </div>
</body>
</html>
