<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Feedback Sent</title>
    <meta http-equiv="refresh" content="3;URL=home" />
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #eaf7f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .msg-box {
            background-color: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 0 20px rgba(0, 128, 128, 0.2);
            text-align: center;
        }
        h2 {
            color: teal;
        }
    </style>
</head>
<body>
<div class="msg-box">
    <h2>Thank you, ${feedbackName}!</h2>
    <p>💌 Your feedback has been received.</p>
    <p>You will be redirected to the home page shortly.</p>
</div>
</body>
</html>
