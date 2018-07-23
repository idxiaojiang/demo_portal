<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/views/common/css/base.css" media="screen" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/views/index.css" media="screen" />
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<script src="https://cdn.bootcss.com/vue/2.5.16/vue.js"></script>
<script src="https://cdn.bootcss.com/js-xss/0.3.3/xss.min.js"></script>
<script src="https://cdn.bootcss.com/layer/3.1.0/layer.js"></script>
<script type="text/javascript" src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/views/index.js"></script>
<title>忆刻网</title>
</head>
<body class="container">
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="padding-left:300px;z-index: 1;opacity:0.8;">
        <div class="navbar-header">
            <a class="navbar-brand" href="<%=request.getContextPath()%>">忆刻网</a>
        </div>
        <!-- 
        <div style="padding-right:100px;margin-right: 300px;">
        	<button class="btn btn-success" style="margin-top: 8px;float:right;margin-right: 10px;">注册</button>
        	<button data-loading-text="loading..." class="btn btn-primary" style="margin-top: 8px;margin-right: 10px;float:right;">登录</button>
        	<button class="btn btn-danger" style="margin-top: 8px;float:right;margin-right: 20px;" id="publish">发表</button>
        </div>
        -->
    </nav>
	<div class="article-container">
		<div class="article-note">
			<div class="note-more">
				<p>最新动态</p>
			</div>
			<div class="note-list">
				<ul>
					<c:forEach items="${newList }" var="item">
						<li>
							<a href="/note/${item.rowId }" target="_blank" style="text-decoration : none;">
							<c:if test="${item.coverImageUrl != '' && item.coverImageUrl != null}">
								<img src="${item.coverImageUrl }"/>
							</c:if>
							<span>${item.title }</span>
							</a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="advertising-container">
		</div>
		<div class="article-note">
			<div class="note-more">
				<p>最赞动态</p>
			</div>
			<div class="note-list">
				<ul>
					<c:forEach items="${hotList }" var="item">
						<li>
							<a href="/note/${item.rowId }" target="_blank" style="text-decoration : none;">
							<c:if test="${item.coverImageUrl != '' && item.coverImageUrl != null}">
								<img src="${item.coverImageUrl }"/>
							</c:if>
							<span>${item.title }</span>
							</a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>