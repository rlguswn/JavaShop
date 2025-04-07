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
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <div id="spinner-overlay" class="spinner-overlay">
            <div class="spinner"></div>
        </div>

        <form action="${pageContext.request.contextPath}/signup" method="post">
            <label for="email">아이디</label>
            <input type="text" id="email" name="email" required autocomplete="username">

            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password" required autocomplete="current-password">

            <label for="username">이름</label>
            <input type="text" id="username" name="username" required autocomplete="name">

            <label for="address">주소</label>
            <input type="text" id="address" name="address" required>

            <button type="submit">회원가입</button>
        </form>
    </div>

    <%@ include file="/WEB-INF/views/fragments/footer.jsp" %>
</body>
</html>