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
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <div id="spinner-overlay" class="spinner-overlay">
            <div class="spinner"></div>
        </div>

        <div class="form-wrapper">
            <form action="${pageContext.request.contextPath}/product/${product.id}/update" method="post" enctype="multipart/form-data" onsubmit="return handleFormSubmit(event)">
                <input type="hidden" id="id" name="id" value="${product.id}">

                <div class="form-group">
                    <label for="name">제품명</label>
                    <input type="text" id="name" name="name" value="${product.name}" required>
                </div>

                <div class="form-group">
                    <label for="description">설명</label>
                    <input type="text" id="description" name="description" value="${product.description}" required>
                </div>

                <div class="form-group">
                    <label for="price">가격</label>
                    <input type="number" id="price" name="price" value="${product.price}" required>
                    <span>
                        <small>가격은 0 이상이어야 합니다.</small>
                    </span>
                </div>

                <div class="form-group">
                    <label for="quantity">수량</label>
                    <input type="number" id="quantity" name="quantity" value="${product.quantity}" required>
                    <span>
                        <small>수량은 1 이상이어야 합니다.</small>
                    </span>
                </div>

                <div class="form-group">
                    <label for="image">이미지 변경</label>
                    <input type="file" id="image" name="image">
                    <p>현재 이미지:
                        <div class="image-cell">
                            <img src="/product/image/${product.id}" alt="상품 이미지">
                        </div>
                    </p>
                </div>

                <button type="submit" class="btn-action">상품수정</button>
            </form>
        </div>

        <a href="${pageContext.request.contextPath}/product" class="btn register-btn">상품 목록</a>

        <script src="${pageContext.request.contextPath}/resources/js/numberInputFilter.js"></script>
    </div>

    <script src="${pageContext.request.contextPath}/resources/js/loading.js"></script>
    <%@ include file="/WEB-INF/views/fragments/footer.jsp" %>
</body>
</html>
