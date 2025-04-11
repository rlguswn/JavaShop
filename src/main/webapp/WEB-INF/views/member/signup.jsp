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

        <div class="form-wrapper">
            <form action="${pageContext.request.contextPath}/signup" method="post" onsubmit="return handleFormSubmit(event)">
                <div class="form-group">
                    <label for="email">아이디</label>
                    <input type="text" id="email" name="email" required autocomplete="username">
                </div>

                <div class="form-group">
                    <label for="password">비밀번호</label>
                    <input type="password" id="password" name="password" required autocomplete="current-password">
                </div>

                <div class="form-group">
                    <label for="username">이름</label>
                    <input type="text" id="username" name="username" required autocomplete="name">
                </div>

                <div class="form-group">
                    <label for="address">주소</label>
                    <input type="text" id="address" name="address" required>
                </div>

                <button type="submit">회원가입</button>
            </form>

            <div class="register-link">
                <p>이미 회원이신가요? <a href="${pageContext.request.contextPath}/login">로그인</a></p>
                <a href="${pageContext.request.contextPath}/test-login/admin">테스트 관리자 계정 로그인</a>
                <a href="${pageContext.request.contextPath}/test-login/member">테스트 유저 계정 로그인</a>
            </div>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/resources/js/loading.js"></script>
    <%@ include file="/WEB-INF/views/fragments/footer.jsp" %>
</body>
</html>