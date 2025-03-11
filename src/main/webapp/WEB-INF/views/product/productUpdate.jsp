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
        <h2>상품 수정</h2>
        <form id="productUpdateForm">
            <input type="hidden" id="id" name="id" value="${product.id}">

            <label for="name">제품명</label>
            <input type="text" id="name" name="name" value="${product.name}" required>

            <label for="description">설명</label>
            <input type="text" id="description" name="description" value="${product.description}" required>

            <label for="price">가격</label>
            <input type="text" id="price" name="price" value="${product.price}" required>

            <label for="quantity">수량</label>
            <input type="text" id="quantity" name="quantity" value="${product.quantity}" required>

            <label for="image">이미지 변경</label>
            <input type="file" id="image" name="image">
            <p>현재 이미지:
                <c:forEach var="image" items="${product.productImages}">
                    <img src="${image.imageData}" alt="상품 이미지" width="100">
                </c:forEach>
            </p>

            <button type="submit">상품수정</button>
        </form>

        <script src="${pageContext.request.contextPath}/resources/js/productUpdate.js"></script>
    </div>

    <%@ include file="/WEB-INF/views/fragments/footer.jsp" %>
</body>
</html>
