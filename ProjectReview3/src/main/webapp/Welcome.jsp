<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Login System</title></head>
<body>
<h1 align="center">Welcome</h1>
    <div align="center">
                <h1><% String  msg = (String)request.getAttribute("msg");
                if (msg!=null)
                out.println(msg);
                 %></h1>
            </div>
</body>
</html>