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
        <h2>상품 상세</h2>
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <table>
            <tr>
                <th>상품명</th>
                <td>${product.name}</td>
            </tr>
            <tr>
                <th>상품 설명</th>
                <td>${product.description}</td>
            </tr>
            <tr>
                <th>가격</th>
                <td>${product.price} 원</td>
            </tr>
            <tr>
                <th>재고</th>
                <td>${product.quantity} 개</td>
            </tr>
            <tr>
                <th>등록일</th>
                <td>${product.createdAt}</td>
            </tr>
        </table>

        <div class="mt-3">
            <div id="spinner-overlay" class="spinner-overlay">
                <div class="spinner"></div>
            </div>
            <form action="${pageContext.request.contextPath}/cart/add" method="post" onsubmit="return handleFormSubmit(event)">
                <input type="hidden" id="productId" name="productId" value="${product.id}">
                <label for="quantity">수량:</label>
                <input type="number" id="quantity" name="quantity" value="1" min="1" max="${product.quantity}" required>
                <span>개</span>
                <button type="submit" class="btn btn-primary">장바구니에 추가</button>
            </form>
        </div>

        <div>
            <a href="${pageContext.request.contextPath}/product/${product.id}/update" class="btn">수정</a>
            <a href="${pageContext.request.contextPath}/product/${product.id}/delete" class="btn" style="background-color: red;">삭제</a>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/resources/js/loading.js"></script>
    <%@ include file="/WEB-INF/views/fragments/footer.jsp" %>
</body>
</html>
