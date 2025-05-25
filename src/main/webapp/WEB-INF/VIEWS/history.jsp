<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, java.util.Map" %>
<%@ include file="header.jspf" %>

<!DOCTYPE html>
<html>
<head>
    <title>Love Calculator - History</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #fff0f5;
            padding: 30px;
        }
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
            background: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(255, 0, 128, 0.2);
        }
        th, td {
            padding: 12px 15px;
            border: 1px solid #f3c5d9;
            text-align: center;
        }
        th {
            background-color: #d63384;
            color: white;
        }
        h2 {
            text-align: center;
            color: #d63384;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <h2>💘 Your Love History 💘</h2>

<%
    List<Map<String, Object>> history = (List<Map<String, Object>>) request.getAttribute("history");
    if (history == null || history.isEmpty()) {
%>
        <p style="text-align:center;">No love results found.</p>
<%
    } else {
%>
    <table>
        <thead>
            <tr>
                <th>Your Name</th>
                <th>Crush Name</th>
                <th>Result</th>
                <th>Calculated At</th>
            </tr>
        </thead>
        <tbody>
<%
        for (Map<String, Object> row : history) {
%>
            <tr>
                <td><%= row.get("yourName") %></td>
                <td><%= row.get("crushName") %></td>
                <td><%= row.get("result") %></td>
                <td><%= row.get("time") %></td>
            </tr>
<%
        }
%>
        </tbody>
    </table>
<%
    }
%>

</body>
</html>