<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <%@ include file="/WEB-INF/views/fragments/header.jsp" %>
</head>
<body>
    <%@ include file="/WEB-INF/views/fragments/navbar.jsp" %>
    <div class="container">
        <h2>회원가입</h2>
        <form action="${pageContext.request.contextPath}/signup" method="post">
            <label for="username">아이디</label>
            <input type="text" id="username" name="username" required>

            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password" required>

            <label for="name">이름</label>
            <input type="text" id="name" name="name" required>

            <button type="submit">회원가입</button>
        </form>
    </div>

    <%@ include file="/WEB-INF/views/fragments/footer.jsp" %>
</body>
</html>