<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ include file="header.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Try with Email - Love Calculator</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #ffe6f0;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            height: 100vh;
        }
        .form-container {
            background-color: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 0 20px rgba(255, 0, 128, 0.2);
            text-align: center;
            width: 90%;
            max-width: 400px;
            margin-top: 50px;
        }
        h2 {
            color: #d63384;
            margin-bottom: 20px;
        }
        input[type="email"] {
            width: 90%;
            padding: 10px;
            border-radius: 8px;
            border: 1px solid #ccc;
            margin-bottom: 20px;
        }
        .submit-btn {
            padding: 10px 20px;
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
        .back-link {
            display: block;
            margin-top: 20px;
            color: #d63384;
            text-decoration: none;
            font-weight: bold;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>📧 Try with Email</h2>
    <form action="sendEmailResult" method="post">
        <input type="email" name="email" placeholder="Enter your email..." required />
        <br>
        <input type="submit" class="submit-btn" value="Send My Love Result" />
    </form>
    <a href="home" class="back-link">🔙 Go Back</a>
</div>

</body>
</html>
