<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>লগইন</title>
</head>
<body>
<form method="post" action="/verify">
    Student ID: <input type="text" name="studentId" />
    <button type="submit">শুরু করুন</button>
</form>
<p style="color:red">${error}</p>
</body>
</html>
