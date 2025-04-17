<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <%@ include file="/WEB-INF/views/fragments/header.jsp" %>
</head>
<body>
    <%@ include file="/WEB-INF/views/fragments/navbar.jsp" %>
    <div class="container">
        <h2>홈</h2>
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <c:if test="${empty todayProducts}">
            <h2>상품을 불러올 수 없습니다.</h2>
        </c:if>
        <c:if test="${not empty todayProducts}">
            <section class="product-section">
                <h2 class="section-title">오늘의 발견</h2>
                <div class="product-grid">
                    <c:forEach var="product" items="${todayProducts}">
                        <div class="product-card">
                            <img src="/product/image/${product.id}" alt="${product.name}">
                            <h3><a href="${pageContext.request.contextPath}/product/${product.id}">${product.name}</a></h3>
                            <p><fmt:formatNumber value="${product.price}" type="number" maxFractionDigits="0"/>원</p>
                            <p>재고: ${product.quantity}개</p>
                        </div>
                    </c:forEach>
                </div>
            </section>
        </c:if>

        <c:if test="${empty limitedProducts}">
            <h2>새로고침을 해주세요.</h2>
        </c:if>
        <c:if test="${not empty limitedProducts}">
            <section class="product-section">
                <h2 class="section-title">한정 수량</h2>
                <div class="product-grid">
                    <c:forEach var="product" items="${limitedProducts}">
                        <div class="product-card">
                            <img src="/product/image/${product.id}" alt="${product.name}">
                            <h3><a href="${pageContext.request.contextPath}/product/${product.id}">${product.name}</a></h3>
                            <p><fmt:formatNumber value="${product.price}" type="number" maxFractionDigits="0"/>원</p>
                            <p>재고: ${product.quantity}개</p>
                        </div>
                    </c:forEach>
                </div>
            </section>
        </c:if>
    </div>

    <%@ include file="/WEB-INF/views/fragments/footer.jsp" %>
</body>
</html>