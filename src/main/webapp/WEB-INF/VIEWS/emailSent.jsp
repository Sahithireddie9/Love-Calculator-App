<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Email Sent</title>
    <!-- Automatically redirect after 2 seconds -->
    <meta http-equiv="refresh" content="2;URL=home" />
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #ffe6f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .message-box {
            background-color: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 0 20px rgba(255, 0, 128, 0.2);
            text-align: center;
        }
        h2 {
            color: #d63384;
        }
        p {
            font-size: 16px;
            color: #444;
        }
    </style>
</head>
<body>
<div class="message-box">
    <h2>📧 Email Sent!</h2>
    <p>You’ll be redirected to the home page in a moment...</p>
</div>
</body>
</html>
