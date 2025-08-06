<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ফলাফল</title>
</head>
<body>
<h2>আপনার স্কোর: ${score} / 2</h2>

<c:choose>
<c:when test="${score == 2}">
<p>অভিনন্দন! আপনি অসাধারণ করেছেন।</p>
</c:when>
<c:when test="${score == 1}">
<p>ভালো চেষ্টা, আরও একটু মনোযোগ দরকার।</p>
</c:when>
<c:otherwise>
<p>চেষ্
