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
        <h2>마이페이지</h2>
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <table>
            <tr>
                <th>아이디</th>
                <td>${member.email}</td>
            </tr>
            <tr>
                <th>이름</th>
                <td>${member.username}</td>
            </tr>
            <tr>
                <th>주소</th>
                <td>${member.address}</td>
            </tr>
            <tr>
                <th>가입일</th>
                <td>${member.formatCreatedAt()}</td>
            </tr>
            <tr>
                <th>장바구니</th>
                <td>${cartItemCount}개의 상품이 장바구니에서 대기중</td>
            </tr>
            <tr>
                <th>주문 내역</th>
                <td>
                    <div class="order-stats">
                        <div class="stat-box">
                            주문 완료: <strong>${orderCount['COMPLETED'] != null ? orderCount['COMPLETED'] : 0}</strong>
                        </div>
                        <div class="stat-box">
                            주문 대기: <strong>${orderCount['PENDING'] != null ? orderCount['PENDING'] : 0}</strong>
                        </div>
                        <div class="stat-box">
                            주문 취소: <strong>${orderCount['CANCELED'] != null ? orderCount['CANCELED'] : 0}</strong>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
    </div>

    <%@ include file="/WEB-INF/views/fragments/footer.jsp" %>
</body>
</html>
