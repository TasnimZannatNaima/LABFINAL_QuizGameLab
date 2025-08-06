<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MCQ কুইজ</title>
</head>
<body>
<h2>📝 নিচের প্রশ্নগুলোর উত্তর দিন:</h2>
<form method="post" action="/submit">
    <!-- Student ID লুকানো ফিল্ড -->
    <input type="hidden" name="studentId" value="${studentId}" />

    <!-- প্রশ্ন শুরু -->
    <c:forEach items="${questions}" var="q" varStatus="loop">
        <div style="margin-bottom: 20px;">
            <p><b>${loop.index + 1}. ${q.questionText}</b></p>

            <c:forEach items="${q.options}" var="opt" varStatus="i">
                <label>
                    <input type="radio" name="ans${loop.index}" value="${i.index}" required />
                        ${opt}
                </label><br/>
            </c:forEach>
        </div>
    </c:forEach>

    <button type="submit">✅ জমা দিন</button>
</form>
</body>
</html>
