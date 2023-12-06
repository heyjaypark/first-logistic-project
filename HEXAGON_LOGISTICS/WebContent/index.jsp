<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hexagon Logistics ver 1.0</title>
<!-- 수정된 CSS 파일 경로 -->
  <link rel="stylesheet" type="text/css" href="css/main.css">


</head>

<body>

<header>
<h1>Hexagon Logistics ver 1.0</h1>
    <div id="loginButton">
    <a href="login.jsp">로그인</a>
  </div>
</header>

<nav>
  <ul>
    <li><a href="#">재고현황</a></li>
    <li><a href="#">재고관리</a></li>
    <li><a href="#">판매/이력</a></li>
    <li><a href="#">공지사항</a></li>
  </ul>

</nav>

<section>

<h2>어서오세요! 헥사곤물류 재고관리 프로그램 메인화면입니다.<br/>
다음의 이미지를 통해 저희 프로그램의 모습을 미리 확인하세요!</h2>

<!-- 이미지 버튼 추가 -->
<button id="introBtn" onclick="displayImage('imageServlet?imageName=intro.png')"></button>
<button id="stockManageBtn" onclick="displayImage('imageServlet?imageName=stockmanage.png')"></button>
<button id="salesBtn" onclick="displayImage('imageServlet?imageName=sales.png')"></button>
<button id="stockListBtn" onclick="displayImage('imageServlet?imageName=stocklist.png')"></button>

<!-- 이미지 표시 영역 -->
<div id="imageDisplay">
        <img src="imageServlet?imageName=intro.png" alt="이미지">
    </div>
<!-- JavaScript 함수 추가 -->
<script>
    function displayImage(imageUrl) {
        document.getElementById('imageDisplay').innerHTML = '<img src="' + imageUrl + '" alt="이미지">';
    }

</script>
    
</section>

<footer>
<p>&copy; 2023 Hexagon Logistics. All rights reserved.</p>
</footer>
</body>
</html>