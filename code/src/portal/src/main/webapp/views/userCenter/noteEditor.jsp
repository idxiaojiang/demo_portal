<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/views/common/css/base.css" media="screen" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/views/userCenter/css/noteEditor.css" media="screen" />
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<script src="https://cdn.bootcss.com/vue/2.5.16/vue.js"></script>
<script src="https://cdn.bootcss.com/js-xss/0.3.3/xss.min.js"></script>
<script src="https://cdn.bootcss.com/layer/3.1.0/layer.js"></script>
<script type="text/javascript" src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/views/common/js/base.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/views/userCenter/js/noteEditor.js"></script>
<title>用户中心-发表文章</title>
</head>
<body class="container">
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="padding-left:300px;z-index: 1;opacity:0.8;">
        <div class="navbar-header">
            <a class="navbar-brand" href="../">忆刻网</a>
        </div>
        <!-- 
        <div style="padding-right:100px;margin-right: 300px;">
        	<button class="btn btn-success" style="margin-top: 8px;float:right;margin-right: 10px;">注册</button>
        	<button data-loading-text="loading..." class="btn btn-primary" style="margin-top: 8px;margin-right: 10px;float:right;">登录</button>
        	<button class="btn btn-danger" style="margin-top: 8px;float:right;margin-right: 20px;" id="publish">发表</button>
        </div>
         -->
    </nav>
	<div style="margin-top:100px;" >
		<div class="navigation-left">
			<ul class="nav nav-pills nav-stacked">
				<li class="active"><a href="<%=request.getContextPath()%>/views/index.html">主页</a></li>
				<li class="active"><a href="<%=request.getContextPath()%>/userCenter/test">Test</a></li>
			</ul>
		</div>
		<div class="editor-container" >
			<div class="input-group" style="margin:20px 20px 30px 20px;height: 50px;">
            	<span class="input-group-addon" style="font-size: 16px;font-weight: 900">标题：</span>
            	<input type="text" id = "titleContent" class="form-control" style="height:50px;font-size: 16px;font-weight: 900;" placeholder="1到50个字" maxlength="50">
        	</div>
        	<div style="margin:auto 20px auto 20px;">
	        	<div id="editor" class="editor">
				</div>
        	</div>
        	<div class="cover-container" id="coverApp">
        		<span  style="font-size: 16px;font-weight: 900;margin-left:30px;height: 30px;">封面：</span>
        		<div class="cover-img" v-on:click="coverImgClick">
        			<img id="coverImg" src="<%=request.getContextPath()%>/views/common/img/icon-add.png" title="点击选择文章中的图片">
        		</div>
        	</div>
        	<div id="editorObject">
        		<button class="btn btn-danger" style="margin-top: 8px;float:right;margin-right: 20px;width: 100px;height: 50px;font-size: 20px;" id="submitClick">发布</button>
        	</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/views/common/plugin/wangEditor-3.1.0/release/wangEditor.min.js"></script>
</body>
</html>