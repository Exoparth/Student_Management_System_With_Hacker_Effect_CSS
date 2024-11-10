<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ty.Register"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <form action="register" method="post">
        <table>
            <tr>
                <td>Name</td>
                <td>:</td>
                <td><input type="text" name="uname" id="uname" placeholder="Enter your name"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td>:</td>
                <td><input type="email" name="uemail" id="uemail" placeholder="Enter your Email"></td>
            </tr>
            <tr>
                <td>Phone no</td>
                <td>:</td>
                <td><input type="number" name="uphone" id="uphone" placeholder="Enter your Phone no"></td>
            </tr>
            <tr>
                <td>Std</td>
                <td>:</td>
                <td><input type="text" name="ustd" id="ustd" placeholder="Enter your Std"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td>:</td>
                <td><input type="password" name="upwd" id="upwd" placeholder="Enter your Password"></td>
            </tr>
            <tr>
                <td colspan="3" style="text-align: center;">
                    <input type="submit" value="Register">
                </td>
            </tr>
            <tr>
                <td colspan="3" style="text-align: center;">
                    <a href="./login.jsp">Login</a>
                </td>
            </tr>
        </table>
        <h2>${msg}</h2>
    </form>
    <!--     
    <script src="./register.js"></script>
     -->
</body>
</html>
