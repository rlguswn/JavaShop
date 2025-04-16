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
        <h2>주문 내역</h2>
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <c:if test="${empty orders}">
            <p>주문 내역이 없습니다.</p>
            <a href="${pageContext.request.contextPath}/product" class="btn-action">상품 목록으로 이동</a>
            <a href="${pageContext.request.contextPath}/cart" class="btn-action">장바구니로 이동</a>
        </c:if>

        <c:if test="${not empty orders}">
            <table class="table">
                <thead>
                    <tr>
                        <th>주문 번호</th>
                        <th>주문 날짜</th>
                        <th>주문 상태</th>
                        <th>총 가격</th>
                        <th>상품 목록</th>
                        <th>상세 보기</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="order" items="${orders}">
                        <tr>
                            <td>${order.id}</td>
                            <td>${order.formatCreatedAt()}</td>
                            <td>${order.status}</td>
                            <td><fmt:formatNumber value="${order.totalPrice}" type="number" maxFractionDigits="0"/>원</td>
                            <td>
                                <c:forEach var="item" items="${order.orderItems}">
                                    ${item.product.name} x ${item.quantity}<br>
                                </c:forEach>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/order/${order.id}" class="btn-action">상세 보기</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>

    <%@ include file="/WEB-INF/views/fragments/footer.jsp" %>
</body>
</html>
