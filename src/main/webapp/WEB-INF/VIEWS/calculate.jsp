<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Love Result</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #ffe6f0;
            margin: 0;
            padding: 0;
        }
        .header-bar {
            text-align: right;
            padding: 10px 20px;
            background: #f8d7e6;
            margin-bottom: 20px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        .user-greeting {
            float: left;
            font-weight: bold;
            color: #d63384;
        }
        .popup {
            background-color: white;
            border-radius: 15px;
            padding: 40px;
            text-align: center;
            box-shadow: 0 0 20px rgba(255, 0, 128, 0.2);
            max-width: 500px;
            margin: 20px auto;
            animation: pop 0.4s ease-out;
        }
        @keyframes pop {
            0% { transform: scale(0.7); opacity: 0; }
            100% { transform: scale(1); opacity: 1; }
        }
        h2 {
            color: #d63384;
            margin-top: 0;
        }
        .love-names {
            display: flex;
            justify-content: center;
            gap: 10px;
            margin: 20px 0;
            flex-direction: column;
            align-items: center;
        }
        .love-names input {
            border: none;
            background: #fff0f5;
            padding: 8px 15px;
            border-radius: 20px;
            text-align: center;
            font-weight: bold;
            color: #d63384;
            font-size: 16px;
            margin: 5px 0;
        }
        .result-display {
            font-size: 24px;
            margin: 25px 0;
            color: #333;
        }
        .result-value {
            color: #d63384;
            font-size: 28px;
            font-weight: bold;
        }
        .actions {
            margin-top: 30px;
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 15px;
        }
        .action-link {
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 8px;
            padding: 12px;
            background: #fff0f5;
            border-radius: 8px;
            color: #d63384;
            font-weight: bold;
            text-decoration: none;
            transition: all 0.3s ease;
        }
        .action-link:hover {
            background: #f8d7e6;
            transform: translateY(-2px);
            box-shadow: 0 4px 8px rgba(214, 51, 132, 0.2);
        }
        .error-message {
            color: #ff3860;
            font-size: 14px;
            margin-top: 5px;
            font-weight: 500;
        }
        .input-error {
            border: 1px solid #ff3860 !important;
            background-color: #fff0f0 !important;
        }
    </style>
</head>
<body>

<%@ include file="header.jspf" %>

<div class="popup">
    <h2>💖 Love Match Result 💖</h2>

    <form:form method="POST" action="calculateResult" modelAttribute="namesInfo">
        <div class="love-names">
            <form:input path="yourname" cssClass="${bindingResult.hasFieldErrors('yourname') ? 'input-error' : ''}" />
            <form:errors path="yourname" cssClass="error-message" />
            
            <span style="color: #d63384; font-weight: bold; margin: 10px 0;">❤️</span>
            
            <form:input path="crushname" cssClass="${bindingResult.hasFieldErrors('crushname') ? 'input-error' : ''}" />
            <form:errors path="crushname" cssClass="error-message" />
        </div>

        <% if (request.getAttribute("error") != null) { %>
            <div class="error-message" style="text-align: center; margin: 15px 0;">
                <%= request.getAttribute("error") %>
            </div>
        <% } %>

        <div class="result-display">
            Your love connection is... 
            <span class="result-value">${result}</span>!
        </div>

        <div class="actions">
            <input type="submit" class="action-link" value="💘 Calculate 💘" style="cursor: pointer; grid-column: span 2;">
            <a class="action-link" href="home">
                <span>🔁</span> Try Again
            </a>
            <a class="action-link" href="tryWithEmail">
                <span>📧</span> Email Result
            </a>
            <a class="action-link" href="feedback">
                <span>📝</span> Feedback
            </a>
            <a class="action-link" href="seeHistory">
                <span>📜</span> View History
            </a>
        </div>
    </form:form>
</div>

</body>
</html>