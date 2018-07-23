<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.bootcss.com/vue/2.5.16/vue.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../views/login/css/loginPage.css" />
<title>欢迎登陆</title>
</head>
<body>
	<div class="container">
		<section id="content">
			<form action="/doLogin" method="POST">
				<h1>会员登录</h1>
				<div>
					<input type="text" placeholder="邮箱" required="required" id="username" name="username"/>
				</div>
				<div>
					<input type="password" placeholder="密码" required="required" id="password" name="password"/>
				</div>
				<div class="">
					<span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>
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