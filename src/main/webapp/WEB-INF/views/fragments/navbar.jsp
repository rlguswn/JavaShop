<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar">
    <div class="container">
        <a href="${pageContext.request.contextPath}/" class="logo">쇼핑몰</a>
        <ul class="nav-links">
            <li><a href="${pageContext.request.contextPath}/product">상품 목록</a></li>
            <li><a href="${pageContext.request.contextPath}/cart">장바구니</a></li>
            <li><a href="${pageContext.request.contextPath}/order">주문 내역</a></li>
            <sec:authorize access="isAuthenticated()">
                <li><a href="${pageContext.request.contextPath}/mypage">마이페이지</a></li>
                <li><a href="${pageContext.request.contextPath}/logout">로그아웃</a></li>
            </sec:authorize>
            <sec:authorize access="isAnonymous()">
                <li><a href="${pageContext.request.contextPath}/login">로그인</a></li>
                <li><a href="${pageContext.request.contextPath}/signup">회원가입</a></li>
            </sec:authorize>
        </ul>
    </div>
</nav>
