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
        <h2>마이페이지</h2>
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <table>
            <tr>
                <th>아이디</th>
                <td>${member.email}</td>
            </tr>
            <tr>
                <th>이름</th>
                <td>${member.username}</td>
            </tr>
            <tr>
                <th>주소</th>
                <td>${member.address}</td>
            </tr>
            <tr>
                <th>가입일</th>
                <td>${createdAt}</td>
            </tr>
        </table>
    </div>

    <%@ include file="/WEB-INF/views/fragments/footer.jsp" %>
</body>
</html>
