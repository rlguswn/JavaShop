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
        <h2>장바구니</h2>
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <c:if test="${empty cartItems}">
            <p>장바구니에 담긴 상품이 없습니다.</p>
        </c:if>

        <c:if test="${not empty cartItems}">
            <form action="${pageContext.request.contextPath}/order/register" method="post" onsubmit="return handleFormSubmit(event)">
                <table class="table">
                    <thead>
                        <tr>
                            <th>상품명</th>
                            <th>상품 이미지</th>
                            <th>가격</th>
                            <th>수량</th>
                            <th>합계</th>
                            <th>상품 제거</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cartItem" items="${cartItems}" varStatus="status">
                            <input type="hidden" name="orderItems[${status.index}].productId" value="${cartItem.product.id}">
                            <input type="hidden" name="orderItems[${status.index}].quantity" value="${cartItem.quantity}">
                            <tr data-product-id="${cartItem.product.id}">
                                <td><a href="${pageContext.request.contextPath}/product/${cartItem.product.id}">${cartItem.product.name}</a></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/product/${cartItem.product.id}">
                                        <div style="text-align: center;">
                                            <img src="/product/image/${cartItem.product.id}" alt="상품 이미지" style="max-width: 300px; max-height: 300px; object-fit: contain; border: 1px solid #ccc; padding: 10px;" />
                                        </div>
                                    </a>
                                </td>
                                <td><fmt:formatNumber value="${cartItem.product.price}" type="number" maxFractionDigits="0"/>원</td>
                                <td class="quantity">${cartItem.quantity}</td>
                                <td><fmt:formatNumber value="${cartItem.product.price * cartItem.quantity}" type="number" maxFractionDigits="0"/>원</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/cart/${cartItem.id}/delete" class="btn-action btn-delete" onclick="return confirm('정말로 제거하시겠습니까?');">제거</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <button type="submit" class="btn register-btn">주문하기</button>
            </form>

            <div id="spinner-overlay" class="spinner-overlay">
                <div class="spinner"></div>
            </div>
        </c:if>
    </div>

    <script src="${pageContext.request.contextPath}/resources/js/loading.js"></script>
    <%@ include file="/WEB-INF/views/fragments/footer.jsp" %>
</body>
</html>