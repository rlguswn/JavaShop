<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <%@ include file="/WEB-INF/views/fragments/header.jsp" %>
</head>
<body>
    <%@ include file="/WEB-INF/views/fragments/navbar.jsp" %>
    <div class="container">
        <h2>장바구니</h2>

        <c:if test="${empty cartItems}">
            <p>장바구니에 담긴 상품이 없습니다.</p>
        </c:if>

        <c:if test="${not empty cartItems}">
            <form action="/cart/update" method="post">
                <table class="table">
                    <thead>
                        <tr>
                            <th>상품명</th>
                            <th>가격</th>
                            <th>수량</th>
                            <th>합계</th>
                            <th>삭제</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cartItem" items="${cartItems}">
                            <tr>
                                <td>${cartItem.productName}</td>
                                <td>${cartItem.price}</td>
                                <td>
                                    <input type="number" name="quantity" value="${cartItem.quantity}" min="1" required>
                                </td>
                                <td>${cartItem.price * cartItem.quantity}</td>
                                <td>
                                    <form action="/cart/${cartItem.id}/delete" method="get" style="display:inline;">
                                        <button type="submit" class="btn btn-danger">삭제</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <button type="submit" class="btn btn-primary">수량 변경</button>
            </form>
        </c:if>
    </div>

    <%@ include file="/WEB-INF/views/fragments/footer.jsp" %>
</body>
</html>