<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NaverLoginTest</title>
<link rel="stylesheet"
	href="<c:url value="/bootstrap/3.3.4/dist/css/bootstrap.min.css" />">
<link rel="stylesheet" href="<c:url value="/css/login.css" />">
</head>
<body>
	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">로그인</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<div style="display: none" id="login-alert"
						class="alert alert-danger col-sm-12"></div>

					<form id="loginform" class="form-horizontal" role="form"
						name="loginForm" method="POST" action="<c:url value="/login/submit" />">

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input id="login-username"
								type="text" class="form-control" name="username" value=""
								placeholder="username or email">
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="login-password"
								type="password" class="form-control" name="password"
								placeholder="password">
						</div>
						<c:if test="${null ne errorMessage}">
						<div>
							<p class="text-danger">${errorMessage}</p>
						</div>
						</c:if>

						<div class="input-group">
							<div class="checkbox">
								<label> <input id="login-remember" type="checkbox"
									name="remember" value="1" />로그인 상태유지
								</label>
							</div>
						</div>


						<div style="margin-top: 10px" class="form-group">
							<!-- Button -->

							<div class="col-sm-12 controls">
								<a id="btn-login" href="#" onclick="javascript:do_login()" class="btn btn-primary">Login </a> <!-- a
									href="${url}"><img
									src="<c:url value="/images/naverid_login_button.png" />"
									height=34 /></a-->

							</div>
						</div>


						<div class="form-group">
							<div class="col-md-12 control">
								<div
									style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
									<p class="text-primary">
										아직 회원이 아니시라면? <a href="<c:url value="/join" />">
											회원가입 </a>
									</p>
								</div>
							</div>
						</div>
					</form>



				</div>
			</div>
		</div>
	</div>

	<script src="<c:url value="/jquery/2.1.3/dist/jquery.min.js"/>"></script>
	<script src="<c:url value="/bootstrap/3.3.4/dist/js/bootstrap.min.js"/>"></script>
	<script type="text/javascript">
		function do_login(){
			document.loginForm.submit();
		}
	</script>
</body>
</html>