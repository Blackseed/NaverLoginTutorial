<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>NaverLoginTest</title>
<link rel="stylesheet" href="<c:url value="/bootstrap/3.3.4/dist/css/bootstrap.min.css" />" >
<link rel="stylesheet" href="<c:url value="/css/main.css" />" >
</head>
<body>

    <div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">NaverLoginTutorial</h3>
              <nav>
                <ul class="nav masthead-nav">
                  <li class="active"><a href="<c:url value="/home" />">home</a></li>
                  <li><a href="<c:url value="/login" />">Login</a></li>
                  <li><a href="<c:url value="/join" />">Sign-in</a></li>
                </ul>
              </nav>
            </div>
          </div>

          <div class="inner cover">
            <h1 class="cover-heading">환영합니다. </h1>
            <p class="lead">여기는 네이버 아이디로 로그인 튜토리얼 페이지입니다.</p>
            <p class="lead">
              <a href="#" class="btn btn-lg btn-default">Learn more</a>
            </p>
          </div>

          <div class="mastfoot">
            <div class="inner">
              <p>tutorial by <a href="https://github.com/blackseed">@Blackseed</a> </p>
            </div>
          </div>

        </div>

      </div>

    </div>

    <script src="<c:url value="/jquery/2.1.3/dist/jquery.min.js"/>"></script>
	<script src="<c:url value="/bootstrap/3.3.4/dist/js/bootstrap.min.js"/>"></script>
	
</body>
</html>