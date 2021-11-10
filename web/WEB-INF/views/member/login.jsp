<%--
  Created by IntelliJ IDEA.
  User: hoyao
  Date: 2021-10-15
  Time: 오후 4:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/resources/css/member/login.css">

	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

</head>
<body>

<div class="wrapper">

	<div class="wrap">
		<form id="login_form" method="post">
			<div class="logo_wrap">
				<span>Book Mall</span>
			</div>
			<div class="login_wrap">
				<div class="id_wrap">
					<div class="id_input_box">
						<input class="id_input" name="memberId">
					</div>
				</div>
				<div class="pw_wrap">
					<div class="pw_input_box">
						<input class="pw_input" name="memberPw">
					</div>
				</div>

				<c:if test="${result == 0}">
					<div class="login_warn">사용자 ID 또는 비밀번호를 잘못 입력하셨습니다.</div>
				</c:if>

				<div class="login_button_wrap">
					<input type="button" class="login_button" value="로그인">
				</div>
			</div>
		</form>

	</div>

</div>

<script>

	$(function () {
		$('.pw_input').keydown(function (key) {
			if(key.keyCode === 13) {
				// 로그인 메서드 서버 요청
				$('#login_form').attr('action', '/member/login.do');
				$('#login_form').submit();
			}
		});
	})

	// 로그인 버튼 클릭
	$('.login_button').on('click', function () {

		// 로그인 메서드 서버 요청
		$('#login_form').attr('action', '/member/login.do');
		$('#login_form').submit();

	})

</script>

</body>
</html>