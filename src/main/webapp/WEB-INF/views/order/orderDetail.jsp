<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <%@ include file="/WEB-INF/views/fragments/header.jsp" %>
    <title>주문 상세</title>
</head>
<body>
    <%@ include file="/WEB-INF/views/fragments/navbar.jsp" %>
    <div class="container">
        <h2>주문 상세</h2>
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <c:if test="${empty order.orderItems}">
            <p>주문한 상품이 없습니다.</p>
        </c:if>

        <c:if test="${not empty order.orderItems}">
            <table class="table">
                <thead>
                    <tr>
                        <th>상품명</th>
                        <th>상품 이미지</th>
                        <th>가격</th>
                        <th>수량</th>
                        <th>합계</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${order.orderItems}">
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/product/${item.product.id}">${item.product.name}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/product/${cartItem.product.id}">
                                    <div style="image-cell">
                                        <img src="/product/image/${product.id}" alt="상품 이미지">
                                    </div>
                                </a>
                            </td>
                            <td><fmt:formatNumber value="${item.product.price}" type="number" maxFractionDigits="0"/>원</td>
                            <td>${item.quantity}</td>
                            <td><fmt:formatNumber value="${item.product.price * item.quantity}" type="number" maxFractionDigits="0"/>원</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <h4>총 주문 금액: <fmt:formatNumber value="${order.totalPrice}" type="number" maxFractionDigits="0"/>원</h4>

            <c:if test="${order.status == 'PENDING'}">
                <div class="button-group">
                    <a href="${pageContext.request.contextPath}/order/${order.id}/complete" class="btn-action" onclick="return confirm('주문 확정 후에는 취소가 불가능합니다.\n정말로 주문하시겠습니까?');">주문 확정</a>
                    <a href="${pageContext.request.contextPath}/order/${order.id}/cancel" class="btn-action btn-delete" onclick="return confirm('정말로 주문을 취소하시겠습니까?');">주문 취소</a>
                </div>
            </c:if>
        </c:if>

        <a href="${pageContext.request.contextPath}/order" class="btn register-btn">주문 목록</a>
    </div>

    <%@ include file="/WEB-INF/views/fragments/footer.jsp" %>
</body>
</html>
