<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Login System</title></head>
<body>
<h1 align="center"> Login System</h1>
<form action="LoginServlet" align="center" method="post">
    Username <input type="text" Placeholder="Username" name="username"><br><br>
    Password <input type="password" Placeholder="Password" name="password"><br><br>
    <input type="submit" value="Login"><br><br>
    <input type="reset" value="Reset"><br><br>
    </form>
    <div align="center">
    <a href="register.jsp"> Register Yourself Here</a>
    <br><br>
    </div>
    <div align="center">
                    <h1><% String  msg = (String)request.getAttribute("msg");
                    if (msg!=null)
                    out.println(msg);
                     %>
                     </h1>
                </div>
</body>
</html>