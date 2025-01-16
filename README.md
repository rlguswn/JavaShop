# JavaShop
- 주제(서비스명): 쇼핑몰(JavaShop)
    - 쇼핑몰 컨셉의 웹 애플리케이션으로, 회원가입부터 상품 관리, 장바구니, 주문 기능까지 제공하는 프로젝트

# 개발 기간
- 25.01.01 ~ 진행중

# 주요 기능
## 🧑‍💼 회원 관리
- 회원가입 및 로그인
## 🛒 상품 관리
- 상품 등록
  - 관리자는 새로운 상품을 등록할 수 있습니다.
- 상품 조회
  - 사용자는 등록된 상품 목록을 확인할 수 있습니다.
- 상품 수정
  - 관리자는 상품 정보를 수정할 수 있습니다.
## 🛍️ 장바구니 기능
- 장바구니 담기
  - 원하는 상품을 장바구니에 추가할 수 있습니다.
- 장바구니 페이지
  - 장바구니에 담긴 상품을 한눈에 확인할 수 있습니다.
- 장바구니 상품 수정
  - 장바구니에 담긴 상품의 수량을 변경할 수 있습니다.
- 장바구니 상품 제거
  - 장바구니에서 불필요한 상품을 삭제할 수 있습니다.
- 장바구니 상품 주문
  - 장바구니에 담긴 상품을 한 번에 주문할 수 있습니다.
## 📦 주문 관리
- 주문하기
  - 상품 구매를 위한 주문을 진행할 수 있습니다.
- 주문 내역 조회
  - 사용자는 자신의 주문 내역을 확인할 수 있습니다.
- 주문 취소
  - 주문을 취소할 수 있습니다.

# DataBase Structure
![JavaShopERD](src/docs/images/JavaShopERD.jpg)

# Index
[1. 기술스택 & 개발환경](#1-기술-스택--개발-환경)  
[2. 프로젝트 요약](#2-프로젝트-요약)  
[3. 주요 기능 소개](#3-주요-기능-소개)  
[4. 라이브 데모](#4-기능별-라이브-데모)  

# 1. 기술 스택 & 개발 환경
<table>
    <thead>
        <tr>
            <th>프론트엔드</th>
            <th>백엔드</th>
        </tr>
    </thead>
    <tbody>
        <tr>
          <td>
            <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">
            <img src="https://img.shields.io/badge/JSP-000000?style=for-the-badge&logo=openjdk&logoColor=white">
            <img src="https://img.shields.io/badge/css3-1572B6?style=for-the-badge&logo=css3&logoColor=white">
          </td>
          <td>
            <img src="https://img.shields.io/badge/Java-000000?style=for-the-badge&logo=openjdk&logoColor=white">
            <img src="https://img.shields.io/badge/JPA-000000?style=for-the-badge&logo=openjdk&logoColor=white">
            <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
            <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
            <img src="https://img.shields.io/badge/springsecurity-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white">
            <img src="https://img.shields.io/badge/JPQL-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
          </td>
        </tr>
    </tbody>
</table>

# 2. 프로젝트 요약
🔎 서비스 전체 개요
- JavaShop은 사용자 편의를 위한 쇼핑몰 웹 애플리케이션입니다.
- 회원가입, 상품 관리, 장바구니, 주문 기능을 제공합니다.
- Spring Security를 통한 인증/인가와 JPA 기반 데이터 관리로 효율적인 서비스를 제공합니다.
<!-- - JSP를 활용해 서버 사이드 렌더링 방식으로 프론트엔드를 구현하고 있습니다. -->

⚙️ 서비스 개발 관점
- 유연한 확장성과 안정성을 고려하여 기능별로 모듈화된 설계를 적용했습니다.
- Spring Security를 통해 회원 관리와 보안을 강화했습니다.
- JPA를 사용하여 데이터베이스 접근 로직을 단순화하고 생산성을 높였습니다.
- 서버 사이드 렌더링 기반으로 JSP와 Spring MVC를 연계해 동적인 웹 UI를 구성하고 있습니다.
  
# 3. 주요 기능 소개
## 🧑 회원 관리
- 회원가입 및 로그인으로 사용자 계정 관리 기능을 제공합니다.
- Spring Security로 안전한 인증 및 인가 처리.

## 🛒 상품 관리
- 관리자가 상품을 등록, 조회, 수정할 수 있는 관리 시스템을 제공합니다.
- 사용자는 다양한 상품을 쉽게 탐색하고 구매할 수 있습니다.

## 🛍️ 장바구니 기능
- 사용자는 원하는 상품을 장바구니에 추가하고, 수량을 수정하거나 삭제할 수 있습니다.
- 장바구니에 담긴 상품을 한 번에 주문할 수 있습니다.

## 📦 주문 관리
- 사용자는 상품을 주문하고, 주문 내역을 확인할 수 있습니다.
- 결제 전 주문 취소 기능도 제공합니다.

# 4. 기능별 라이브 데모
구현 예정