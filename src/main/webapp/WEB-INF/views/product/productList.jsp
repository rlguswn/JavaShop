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
        <h2>상품 목록</h2>
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <table>
            <thead>
                <tr>
                    <th>상품명</th>
                    <th>가격 (단위: 원)</th>
                    <th>재고</th>
                    <th>수정</th>
                    <th>삭제</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/product/${product.id}">${product.name}</a></td>
                        <td>${product.price}</td>
                        <td>${product.quantity}</td>
                        <td><a href="${pageContext.request.contextPath}/product/${product.id}/update">수정</td>
                        <td><a href="${pageContext.request.contextPath}/product/${product.id}/delete" onclick="return confirm('정말로 삭제하시겠습니까?');">삭제</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div>
            <a href="${pageContext.request.contextPath}/product/register" class="btn">상품 등록</a>
        </div>
    </div>

    <%@ include file="/WEB-INF/views/fragments/footer.jsp" %>
</body>
</html>
