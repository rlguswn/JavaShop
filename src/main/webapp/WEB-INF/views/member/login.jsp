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
        <h2>로그인</h2>
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <div id="spinner-overlay" class="spinner-overlay">
            <div class="spinner"></div>
        </div>

        <div class="form-wrapper">
            <form action="${pageContext.request.contextPath}/login" method="post" onsubmit="return handleFormSubmit(event)">
                <div class="form-group">
                    <label for="email">아이디</label>
                    <input type="text" id="email" name="email" required>
                </div>

                <div class="form-group">
                    <label for="password">비밀번호</label>
                    <input type="password" id="password" name="password" required>
                </div>

                <button type="submit">로그인</button>
            </form>

            <div class="register-link">
                <p>아직 회원이 아니신가요? <a href="${pageContext.request.contextPath}/signup">회원가입</a></p>
                <div class="button-group">
                    <a href="${pageContext.request.contextPath}/test-login/admin" class="btn btn-action highlight">테스트 관리자<br>로그인</a>
                    <a href="${pageContext.request.contextPath}/test-login/member" class="btn btn-action highlight">테스트 유저<br>로그인</a>
                </div>
            </div>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/resources/js/loading.js"></script>
    <%@ include file="/WEB-INF/views/fragments/footer.jsp" %>
</body>
</html>