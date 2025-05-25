<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Send Feedback</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #ffe6f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .form-container {
            background-color: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 0 20px rgba(255, 0, 128, 0.2);
            width: 90%;
            max-width: 500px;
            text-align: center;
        }
        h2 {
            color: #d63384;
            margin-bottom: 20px;
        }
        input, textarea {
            width: 90%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 8px;
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
        .error {
            color: red;
            font-size: 12px;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>💬 Send Feedback</h2>
    <form:form action="submitFeedback" method="post" modelAttribute="feedbackDTO">
        
        <form:input path="name" placeholder="Your Name" />
        <form:errors path="name" cssClass="error" />
        <br>

        <form:input path="email" type="email" placeholder="Your Email" />
        <form:errors path="email" cssClass="error" />
        <br>

        <form:textarea path="message" rows="5" placeholder="Your Message..." />
        <form:errors path="message" cssClass="error" />
        <br>

        <input type="submit" class="submit-btn" value="Send Feedback" />
    </form:form>
</div>

</body>
</html>
