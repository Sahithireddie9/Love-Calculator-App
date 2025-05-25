<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>




<!DOCTYPE html>
<html>
<head>
    <title>Love Calculator - Register</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #ffe6f0;
            margin: 0;
            padding: 30px 0;
        }
        .register-container {
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
        input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 8px;
        }
        .inline-group {
            margin-top: 10px;
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
        }
        .inline-group label {
            font-weight: normal;
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
        .error {
            color: red;
            font-size: 12px;
        }
        
        .login-link {
            text-align: center;
            margin-top: 15px;
            font-size: 14px;
        }
        .login-link a {
            color: #d63384;
            text-decoration: none;
            font-weight: bold;
        }
        .login                   -link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="register-container">
    <h2>Register 💘</h2>
    <form:form method="post" action="processResult" modelAttribute="registerInfo">

        <label>Full Name</label>
        <form:input path="name"/>
        <form:errors path="name" cssClass="error"/>

        <label>Age</label>
        <form:input path="age" type="number"/>
        <form:errors path="age" cssClass="error"/>

        <label>Email</label>
        <form:input path="email" type="email"/>
        <form:errors path="email" cssClass="error"/>
	        <% if (request.getAttribute("emailError") != null) { %>
	    <div class="error"><%= request.getAttribute("emailError") %></div>
	<% } %>
	        
      

        <label>Password</label>
        <form:password path="password"/>
        <form:errors path="password" cssClass="error"/>

        <label>Gender</label>
        <div class="inline-group">
            <label><form:radiobutton path="gender" value="Male"/> Male</label>
            <label><form:radiobutton path="gender" value="Female"/> Female</label>
            <label><form:radiobutton path="gender" value="Other"/> Other</label>
        </div>
        <form:errors path="gender" cssClass="error"/>

        <label>Hobbies</label>
        <div class="inline-group">
            <label><form:checkbox path="hobbies" value="Playing"/> Playing</label>
            <label><form:checkbox path="hobbies" value="Cricket"/> Cricket</label>
            <label><form:checkbox path="hobbies" value="Singing"/> Singing</label>
            <label><form:checkbox path="hobbies" value="Dancing"/> Dancing</label>
        </div>
        <form:errors path="hobbies" cssClass="error"/>

        <label>
            <form:checkbox path="agree"/> I agree this app is for fun 🎉
        </label>
        <form:errors path="agree" cssClass="error"/>

        <input class="submit-btn" type="submit" value="Register ❤️"/>
    </form:form>
    <div class="login-link">
        Already have an account
        <a href="login">Sign in here</a>
    </div>
</div>
</body>
</html>
