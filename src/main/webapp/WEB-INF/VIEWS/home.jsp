<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
    String currentPage = request.getRequestURI();
    boolean showLogout = !(currentPage.contains("login") || currentPage.contains("register"));
%>

<!DOCTYPE html>
<html>
<head>
    <title>Love Calculator - Home</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #ffe6f0;
            margin: 0;
            padding: 30px 0;
        }
        .home-container {
            background-color: white;
            padding: 30px 40px;
            margin: 0 auto;
            border-radius: 15px;
            box-shadow: 0 0 15px rgba(255, 0, 128, 0.2);
            width: 90%;
            max-width: 400px;
            text-align: center;
        }
        h2 {
            color: #d63384;
        }
        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
            text-align: left;
        }
        input[type="text"] {
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
        .greeting {
            font-size: 18px;
            margin-bottom: 15px;
            color: #444;
        }
        .note {
            font-size: 14px;
            color: #777;
            margin-top: 20px;
        }
        .header-bar {
            background-color: #f8d7e6;
            padding: 10px;
            text-align: right;
            margin-bottom: 20px;
            border-radius: 5px;
        }
        .error {
            color: red;
            font-size: 14px;
        }
        .welcome-message {
            color: #d63384;
            font-weight: bold;
            margin-bottom: 20px;
            font-size: 18px;
        }
    </style>
</head>
<body>
    <% if (showLogout && session.getAttribute("userEmail") != null) { %>
        <div class="header-bar">
            Logged in as: <strong><%= session.getAttribute("userEmail") %></strong>
            | <a href="logout" style="color: #d63384; font-weight: bold;">Logout</a>
        </div>
    <% } %>

    <div class="home-container">
        <h2>💖 Love Calculator 💖</h2>
        
        <% if (session.getAttribute("userName") != null) { %>
            <div class="welcome-message">
                Hi, <%= session.getAttribute("userName") %>! ❤️
            </div>
        <% } %>

        <form:form method="Post" action="calculateResult" modelAttribute="namesInfo">
            <label>Your Name</label>
            <form:input path="yourname" />
            <form:errors path="yourname" cssClass="error"/>

            <label>Your Crush's Name</label>
            <form:input path="crushname" />
            <form:errors path="crushname" cssClass="error"/>

            <input class="submit-btn" type="submit" value="💘 Calculate 💘" />
        </form:form>

        <div class="note">✨ Love is just a click away... ✨</div>
    </div>
</body>
</html>