<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/views/login/css/loginPage.css" />
<script src="https://cdn.bootcss.com/vue/2.5.16/vue.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<title>欢迎登陆</title>
</head>
<body>
	<div class="container">
		<section id="content">
			<form action="<%=request.getContextPath()%>/doLogin" method="POST">
				<h1>会员登录</h1>
				<div>
					<input type="text" placeholder="邮箱" required="required" id="username" name="username"/>
				</div>
				<div>
					<input type="password" placeholder="密码" required="required" id="password" name="password"/>
				</div>
				<div>
					<input type="text" placeholder="验证码" required="required" id="verifyCode" name="verifyCode"/>
				</div>
				<div class="verifyCode">
					<img alt="点击刷新验证码" src="<%=request.getContextPath()%>/test/verifyCode/login">
				</div>
				<div class="">
					<span class="help-block u-errormessage" style="color:red" id="js-server-helpinfo">ssssssss</span>
				</div>
				<div>
					<input type="submit" value="登录" class="btn btn-primary"
						id="js-btn-login" />
						<a href="/register">注册会员</a>
				</div>
			</form>
		</section>
	</div>
	<div style="text-align: center;"></div>
</body>
</html>