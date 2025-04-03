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
        <h2>상품 등록</h2>
        <form id="productRegisterForm">
            <label for="name">제품명</label>
            <input type="text" id="name" name="name" required>

            <label for="description">설명</label>
            <input type="text" id="description" name="description" required>

            <label for="price">가격</label>
            <input type="number" id="price" name="price" required>

            <label for="quantity">수량</label>
            <input type="number" id="quantity" name="quantity" required>

            <label for="image">이미지</label>
            <input type="file" id="image" name="image">

            <button type="submit">상품등록</button>
        </form>

        <script src="${pageContext.request.contextPath}/resources/js/productRegister.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/numberInputFilter.js"></script>
    </div>

    <%@ include file="/WEB-INF/views/fragments/footer.jsp" %>
</body>
</html>
