<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Register Stolen Vehicle</title></head>
<body>
<h1 align="center"> Register Yourself</h1>
<form action="RegisterServlet" align="center" method="post">
    Username <input type="text" Placeholder="Username" name="username"><br><br>
    Password <input type="password" Placeholder="Password" name="password"><br><br>
    Role <input type="text" Placeholder="Role" name="role"><br><br>
    <input type="submit" value="Register"><br><br>
    <input type="reset" value="Reset"><br><br>
    </form>
    <div align="center">
    <a href="index.jsp"> Login If Already Registered</a>
    <br><br>
    </div>
    <div align="center">
            <% String  msg = (String)request.getAttribute("msg");
            if (msg!=null)
            out.println(msg);
             %>
        </div>
</body>
</html>