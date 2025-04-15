<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <%@ include file="/WEB-INF/views/fragments/header.jsp" %>
</head>
<body>
    <%@ include file="/WEB-INF/views/fragments/navbar.jsp" %>
    <div class="container">
        <h2>상품 상세</h2>
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <div id="spinner-overlay" class="spinner-overlay">
            <div class="spinner"></div>
        </div>

        <table>
            <tr>
                <th>상품명</th>
                <td>${product.name}</td>
            </tr>
            <tr>
                <th>상품 이미지</th>
                <td>
                    <a href="${pageContext.request.contextPath}/product/${cartItem.product.id}">
                        <div style="image-cell">
                            <img src="/product/image/${product.id}" alt="상품 이미지">
                        </div>
                    </a>
                </td>
            </tr>
            <tr>
                <th>상품 설명</th>
                <td>${product.description}</td>
            </tr>
            <tr>
                <th>가격</th>
                <td><fmt:formatNumber value="${product.price}" type="number" maxFractionDigits="0"/>원</td>
            </tr>
            <tr>
                <th>재고</th>
                <td>${product.quantity}</td>
            </tr>
            <tr>
                <th>등록일</th>
                <td>${product.formatCreatedAt()}</td>
            </tr>
        </table>

        <div class="product-buttons">
            <form action="${pageContext.request.contextPath}/cart/add" method="post" onsubmit="return handleFormSubmit(event)">
                <input type="hidden" id="productId" name="productId" value="${product.id}">
                <label for="quantity">수량:</label>
                <input type="number" id="quantity" name="quantity" value="1" min="1" max="${product.quantity}" required>
                <span>개</span>
                <button type="submit" class="btn-action">장바구니에 추가</button>
            </form>
            <sec:authorize access="hasRole('ADMIN')">
                <div class="button-group">
                    <a href="${pageContext.request.contextPath}/product/${product.id}/update" class="btn-action">수정</a>
                    <a href="${pageContext.request.contextPath}/product/${product.id}/delete" class="btn-action btn-delete">삭제</a>
                </div>
            </sec:authorize>
        </div>

        <a href="${pageContext.request.contextPath}/product" class="btn register-btn">상품 목록</a>
    </div>

    <script src="${pageContext.request.contextPath}/resources/js/loading.js"></script>
    <%@ include file="/WEB-INF/views/fragments/footer.jsp" %>
</body>
</html>
