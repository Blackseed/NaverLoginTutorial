<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NaverLoginTest</title>
<link rel="stylesheet" href="<c:url value="/bootstrap/3.3.4/dist/css/bootstrap.min.css" />" >
<link rel="stylesheet" href="<c:url value="/css/login.css" />" >

</head>
<body>
	<div class="container">
		<div id="signupbox" style="display: block; margin-top: 50px"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">회원가입</div>
					<div
						style="float: right; font-size: 85%; position: relative; top: -10px">
						<a id="signinlink" href="#"
							onclick="$('#signupbox').hide(); $('#loginbox').show()"><p class="text-primary">로그인</p></a>
					</div>
				</div>
				<div class="panel-body">

					<div class="stepwizard">
						<div class="stepwizard-row setup-panel">
							<div class="stepwizard-step">
								<a href="#step-1" type="button"
									class="btn btn-default btn-circle" disabled="disabled">1</a>
								<p>약관동의</p>
							</div>
							<div class="stepwizard-step">
								<a href="#step-3" type="button"
									class="btn btn-info btn-circle" >2</a>
								<p>가입정보추가입력</p>
							</div>
							<div class="stepwizard-step">
								<a href="#step-4" type="button"
									class="btn btn-default btn-circle" disabled="disabled">3</a>
								<p>가입완료</p>
							</div>

						</div>
					</div>

					<div id="joinformbox" style="display:block;">
					<form id="joinForm" class="form-horizontal" name="joinForm" action="<c:url value="/join/sns/done" />" method="POST" role="form">
						<input type="hidden" name="captchaKey" value="${captchaKey}" />
						<div class="form-group">
  							<div class="col-md-6 col-md-offset-3">
								<img height="100" src="${captchaImageUrl}">
								</div>
  						</div>


						<div class="form-group">
							<label class="col-md-3 control-label" for="Nickname">자동가입방지문자</label>
							<div class="col-md-9">
								<input type="text" placeholder="이미지에 보이는 글자를 입력하세요." name="captchaInput" class="form-control">
							</div>
						</div>
						<c:if test="${null ne errorMessage}">
						<div id="signupalert" style="display: block"
							class="alert alert-danger">
							<span>${ errorMessage }</span>
						</div>

						</c:if>
						
						<div style="border-top: 1px solid #999; padding-top: 20px"
							class="form-group">
							<label class="col-md-3 control-label" for="Username">Username</label>
							<div class="col-md-9" style="padding-top:7px;">
							<input type="text" placeholder="Username을 입력하세요." name="username" class="form-control" value="${suggestUserName}">
							</div>
						</div>
						
						<div class="form-group">

							<label class="col-md-3 control-label" for="Email">Email</label>
							<div class="col-md-9" style="padding-top:7px;">
							<p>${user.email}</p>
							</div>

						</div>
						
						<div class="form-group">

							<label class="col-md-3 control-label" for="Nickname">Nickname</label>
							<div class="col-md-9" style="padding-top:7px;">
							<p>${user.nickname}</p>
							</div>

						</div>
						
						
						<div style="border-top: 1px solid #999; padding-top: 20px"
							class="form-group">

							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<button id="btn-join" type="button" class="btn btn-info">
									<i class="icon-hand-right"></i> &nbsp; 위의 정보로 가입을 완료합니다. 
								</button>
							</div>

						</div>

					</form>
					</div>
				
				</div>
			</div>




		</div>
	</div>

	<script src="<c:url value="/jquery/2.1.3/dist/jquery.min.js"/>"></script>
	<script src="<c:url value="/bootstrap/3.3.4/dist/js/bootstrap.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/login.js" />" ></script>
	
</body>
</html>