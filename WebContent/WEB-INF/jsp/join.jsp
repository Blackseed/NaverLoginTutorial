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
						<a href="<c:url value="/login" />"><p class="text-primary">로그인</p></a>
					</div>
				</div>
				<div class="panel-body">

					<div class="stepwizard">
						<div class="stepwizard-row setup-panel">
							<div class="stepwizard-step">
								<a href="#step-1" type="button"
									class="btn btn-info btn-circle">1</a>
								<p>약관동의</p>
							</div>
							<div class="stepwizard-step">
								<a href="#step-2" type="button"
									class="btn btn-default btn-circle" disabled="disabled">2</a>
								<p>가입정보입력</p>
							</div>
							<div class="stepwizard-step">
								<a href="#step-3" type="button"
									class="btn btn-default btn-circle" disabled="disabled">3</a>
								<p>가입정보확인</p>
							</div>
							<div class="stepwizard-step">
								<a href="#step-4" type="button"
									class="btn btn-default btn-circle" disabled="disabled">4</a>
								<p>가입완료</p>
							</div>

						</div>
					</div>

					<div id="termbox">
					<form id="temform" class="form-horizontal" role="form">

						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">서비스 이용약관</h3>
							</div>
							<div class="panel-body">
								<h4 class="h_sub">제 1 조 목적</h4>
								<p class="p_desc">이 약관은 회사와 이용 고객 간에 회사가 제공하는 웹페이지에 기술된 서비스의
									이용과 관련하여 "회사"와 "이용자"의 권리, 의무 및 책임에 관한 제반 사항과 기타 필요한 사항을 구체적으로
									규정함을 목적으로 합니다.</p>
								<h4 class="h_sub">제 2 조 용어의 정의</h4>
								<h5 class="h_subsub">2.1. 이 약관에서 사용하는 용어의 정의는 다음과 같습니다.</h5>
								<ul class="list_type5 gap">
									<li><em>2.1.1.</em> <span>"이용자" 라 함은 네이버 "회원"으로서 본
											약관에 따라 "회사"와 이용계약을 체결하고 "회사"가 제공하는 "서비스"를 이용하는 자를 말합니다.</span></li>
									<li><em>2.1.2.</em> <span>"웹페이지" 라 함은 "회사"가 "서비스"를
											제공하고 있는 웹페이지를 말합니다.</span></li>
								</ul>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">개인정보 수집 및 이용에 대한 안내</h3>
							</div>
							<div class="panel-body">
								<p class="p_desc">정보통신망법 규정에 따라 네이버에 회원가입 신청하시는 분께 수집하는
									개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간을 안내 드리오니 자세히 읽은 후
									동의하여 주시기 바랍니다.</p>
								<h4 class="h_sub">수집하는 개인정보</h4>
								<h5 class="h_subsub">회원가입 시점에 이용자로부터 수집하는 개인정보는 아래와 같습니다.</h5>
								<ul class="list_type5 gap">
									<li><span> 회원 가입 시에 ‘아이디, 비밀번호, 이름, 생년월일, 성별,
											휴대폰번호’를 필수항목으로 수집합니다.</span></li>
								</ul>
								<h5 class="h_subsub">서비스 이용 과정에서 이용자로부터 수집하는 개인정보는 아래와
									같습니다.</h5>
								<ul class="list_type5 gap">
									<li><span> 이벤트 응모 및 경품 신청 과정에서 해당 서비스의 이용자에 한해 추가
											개인정보 수집이 발생할 수 있습니다.</span></li>
									<li><span> 추가로 개인정보를 수집할 경우에는 해당 개인정보 수집 시점에서 이용자에게
											‘수집하는 개인정보 항목, 개인정보의 수집 및 이용목적, 개인정보의 보관기간’에 대해 안내 드리고 동의를
											받습니다.</span></li>
								</ul>
							</div>
						</div>

						<div style="border-top: 1px solid #999; padding-top: 20px" class="form-group">

							<div class="col-md-12">
								<label for="term" class="btn btn-info col-md-12">서비스 이용약관 및
									개인정보 수집 및 이용에 동의합니다. <input type="checkbox" id="term"
									class="badgebox"><span class="badge">&check;</span>
								</label>
							</div>

						</div>

					</form>
					</div>
					<div id="joinformbox" style="display:none;">
					<form id="joinForm" class="form-horizontal" name="joinForm" action="<c:url value="/join/confirm" />" method="POST" role="form">

						<div id="signupalert" style="display: none"
							class="alert alert-danger">
							<p>Error:</p>
							<span></span>
						</div>



						<div class="form-group">
							<label for="username" class="col-md-3 control-label">Username</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="username"
									placeholder="User Name">
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="col-md-3 control-label">Password</label>
							<div class="col-md-9">
								<input type="password" class="form-control" name="password"
									placeholder="Password">
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-md-3 control-label">Email</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="email"
									placeholder="Email">
							</div>
						</div>
						<div class="form-group">
							<label for="Nickname" class="col-md-3 control-label">Nickname</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="nickname"
									placeholder="Nickname">
							</div>
						</div>
						<div class="form-group">
							<label for="mobile" class="col-md-3 control-label">Mobile</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="mobile"
									placeholder="Mobile">
							</div>
						</div>

						<div style="border-top: 1px solid #999; padding-top: 20px"
							class="form-group">

							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<button id="btn-join" type="button" class="btn btn-info">
									<i class="icon-hand-right"></i> &nbsp; 다음단계로 
								</button>
								<span style="margin-left: 8px;">or</span>
							</div>

						</div>

						<div class="form-group">

							<div class="col-md-offset-3 col-md-9">
								<a href="${url}"><img
									src="<c:url value="/images/naverid_login_button.png" />"
									height=34 /></a>
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