<%--
  Created by IntelliJ IDEA.
  User: hoyao
  Date: 2021-10-15
  Time: 오후 3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>

  </head>
  <body>
  <h1>
    ㅎㅎㅎ
  </h1>
  <p>현재 시간 ${serverTime}.</p>

  <h2>5초 뒤에 페이지 이동</h2>
  </body>

  <script>
    $(function(){
      setTimeout(function () {
        location = '/main';
      }, 5000);
    });

  </script>

</html>
