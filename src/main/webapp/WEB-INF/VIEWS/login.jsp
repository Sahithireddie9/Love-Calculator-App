<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Love Calculator - Login</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #ffe6f0;
            margin: 0;
            padding: 30px 0;
        }
        .login-container {
            background-color: white;
            padding: 30px 40px;
            margin: 0 auto;
            border-radius: 15px;
            box-shadow: 0 0 15px rgba(255, 0, 128, 0.2);
            width: 90%;
            max-width: 400px;
        }
        h2 {
            text-align: center;
            color: #d63384;
        }
        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 8px;
        }
        .submit-btn {
            margin-top: 20px;
            width: 100%;
            padding: 12px;
            background-color: #d63384;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
        }
        .submit-btn:hover {
            background-color: #bf2a74;
        }
        .register-link {
            text-align: center;
            margin-top: 15px;
            font-size: 14px;
        }
        .register-link a {
            color: #d63384;
            text-decoration: none;
            font-weight: bold;
        }
        .register-link a:hover {
            text-decoration: underline;
        }
        .error {
            color: red;
            font-size: 12px;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Login to Love Calculator 💖</h2>

    <form:form method="Post" action="processresult" modelAttribute="loginInfo">
        <label for="email">Email</label>
        <form:input path="email" type="email"/>
        <form:errors path="email" cssClass="error"/>
         <% if (request.getAttribute("emailError") != null) { %>
	    <div class="error"><%= request.getAttribute("emailError") %></div>
	<% } %>

        <label for="password">Password</label>
        <form:password path="password"/>
        <form:errors path="password" cssClass="error"/>
         <% if (request.getAttribute("passwordError") != null) { %>
	    <div class="error"><%= request.getAttribute("passwordError") %></div>
	<% } %>

        <input class="submit-btn" type="submit" value="Login 💘"/>
    </form:form>

    <div class="register-link">
        Don't have an account?
        <a href="register">Register here</a>
    </div>
</div>
</body>
</html>

