<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.ty.UpdateServlet" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
 @charset "ISO-8859-1";
/* Basic Reset */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

/* Body Styling */
body {
    background-color: #000000; /* Dark background */
    color: #00ff00; /* Neon green text */
    font-family: 'Courier New', Courier, monospace; /* Monospaced font */
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    flex-direction: column;
    text-align: center;
}

/* Typewriter Effect on h1 */
h1 {
    font-size: 48px;
    font-family: 'Courier New', Courier, monospace;
    color: #00ff00; /* Neon green */
    overflow: hidden; /* Ensures text is hidden until typed */
    white-space: nowrap; /* Prevent text from wrapping */
    border-right: 4px solid #00ff00; /* Typewriter cursor effect */
    width: 0; /* Starts with no visible text */
    animation: typing 4s steps(40) 1s forwards, blink-caret 0.75s step-end infinite; /* Typewriter effect with blinking cursor */
}

/* Typewriter Animation */
@keyframes typing {
    from {
        width: 0;
    }
    to {
        width: 100%;
    }
}

/* Blinking Cursor Animation */
@keyframes blink-caret {
    50% {
        border-color: transparent; /* Makes the caret disappear */
    }
}

/* Button Styling */
input[type="submit"] {
    background-color: #00ff00;
    color: #000;
    font-family: 'Courier New', Courier, monospace;
    font-size: 20px;
    padding: 10px 20px;
    border: 2px solid #00ff00;
    cursor: pointer;
    transition: background-color 0.3s ease, color 0.3s ease;
}

input[type="submit"]:hover {
    background-color: #000;
    color: #00ff00;
}

</style>
</head>

<body>
	<h1>${msg }</h1>
	 <% 
        
        String uname = (String) request.getSession().getAttribute("uname"); 
   		 %>
	<form action="DetailsServlet" method="post">	
		<input type="submit" value="Show Details">
	</form>
</body>
</html>