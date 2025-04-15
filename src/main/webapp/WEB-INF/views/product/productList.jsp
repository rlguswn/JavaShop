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
        <h2>상품 목록</h2>
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <table>
            <thead>
                <tr>
                    <th>상품명</th>
                    <th>상품 이미지</th>
                    <th>가격</th>
                    <th>재고</th>
                    <th>기타</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/product/${product.id}">${product.name}</a></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/product/${cartItem.product.id}">
                                <div style="image-cell">
                                    <img src="/product/image/${product.id}" alt="상품 이미지">
                                </div>
                            </a>
                        </td>
                        <td><fmt:formatNumber value="${product.price}" type="number" maxFractionDigits="0"/>원</td>
                        <td>${product.quantity}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/product/${product.id}/update" class="btn-action">수정</a>
                            <a href="${pageContext.request.contextPath}/product/${product.id}/delete" class="btn-action btn-delete" onclick="return confirm('정말로 삭제하시겠습니까?');">삭제</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div>
            <a href="${pageContext.request.contextPath}/product/register" class="btn register-btn">상품 등록</a>
        </div>
    </div>

    <%@ include file="/WEB-INF/views/fragments/footer.jsp" %>
</body>
</html>
