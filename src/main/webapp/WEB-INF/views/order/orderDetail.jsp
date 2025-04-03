<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

        <c:if test="${empty order.orderItems}">
            <p>주문한 상품이 없습니다.</p>
        </c:if>

        <c:if test="${not empty order.orderItems}">
            <table class="table">
                <thead>
                    <tr>
                        <th>상품명</th>
                        <th>가격</th>
                        <th>수량</th>
                        <th>합계</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${order.orderItems}">
                        <tr>
                            <td>${item.product.name}</td>
                            <td>${item.product.price}</td>
                            <td>${item.quantity}</td>
                            <td>${item.product.price * item.quantity}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <h4>총 주문 금액: ${order.totalPrice} 원</h4>

            <c:if test="${order.status == 'PENDING'}">
                <form action="${pageContext.request.contextPath}/order/${order.id}/complete" method="get">
                    <button type="submit" class="btn btn-success">주문 확정</button>
                </form>

                <form action="${pageContext.request.contextPath}/order/${order.id}/cancel" method="get">
                    <button type="submit" class="btn btn-danger">주문 취소</button>
                </form>
            </c:if>
        </c:if>

        <a href="${pageContext.request.contextPath}/" class="btn btn-primary">메인 페이지로</a>
    </div>

    <%@ include file="/WEB-INF/views/fragments/footer.jsp" %>
</body>
</html>
