<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Student</title>
    <link rel="stylesheet" type="text/css" href="update.css">
</head>
<body>
    <div class="form-container">
        <h2>Update Student Details</h2>
        <form action="UpdateServlet" method="post">
            <label>Name: </label>
            <input type="text" name="uname" required>
            <label>Phone: </label>
            <input type="number" name="uphone" required>
            <label>Std: </label>
            <input type="text" name="ustd" required>
            <label>Password: </label>
            <input type="password" name="upwd" required>
            <input type="submit" value="Update Student">
        </form>
    </div>
</body>
</html>
