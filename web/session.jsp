<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Session Tracking Info</title>
</head>
<body>
    <h1>Session Tracking Information</h1>
    <% 
        String sessionId = session.getId();
        Object userIdObj = session.getAttribute("user_id");
        int userId = (userIdObj != null) ? (int) userIdObj : 0;
        String username = (String) session.getAttribute("username");
        Date loginTime = (Date) session.getAttribute("login_time");
    %>
    <p>Session ID: <%= sessionId %></p>
    <p>Login Time: <%= loginTime %></p>
</body>
</html>