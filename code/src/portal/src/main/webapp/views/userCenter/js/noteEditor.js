var editor;
$(document).ready(function() {
	pageInit();
	pageBindEvent();
});

var pageInit = function(){
	var E = window.wangEditor
	editor = new E('#editor')
	editor.customConfig.uploadImgServer = '/userCenter/uploadImage';
	editor.customConfig.uploadFileName = 'multipartFile';
	editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;
	editor.customConfig.uploadImgMaxLength = 1;
	editor.customConfig.debug = true;
	editor.customConfig.menus = [
		 	'head',  // 标题
		    'bold',  // 粗体
		    'fontSize',  // 字号
		    'fontName',  // 字体
		    'italic',  // 斜体
		    'underline',  // 下划线
		    'strikeThrough',  // 删除线
		    'foreColor',  // 文字颜色
		    'backColor',  // 背景颜色
		    'link',  // 插入链接
		    'list',  // 列表
		    'justify',  // 对齐方式
		    'quote',  // 引用
		    'emoticon',  // 表情
		    'image',  // 插入图片
		    'table',  // 表格
		    //'video',  // 插入视频
		    'code',  // 插入代码
		    'undo',  // 撤销
		    'redo'  // 重复
	];
	editor.customConfig.uploadImgHooks = {
		customInsert : function(insertImg, result, editor) {
			var url = result.result.data;
			insertImg(url);
		}
	}
	editor.create();

}
var pageBindEvent = function(){
	//绑定提交事件
	$('#submitClick').bind('click', function() {
		var title = $("#titleContent").val();
		if (title == null || title == undefined || title == "") {
			layer.alert("一定要填写标题才能发布", {
				icon : 5,
				title : "提示"
			});
			return false;
		}
		var text = editor.txt.text();
		if (text == null || text == undefined || text == "") {
			layer.alert("一定要编写内容才能发布的哟(＾Ｕ＾)ノ~ＹＯ", {
				icon : 5,
				title : "提示"
			});
			return false;
		}

		var html = editor.txt.html();
		var filterHtml = filterXSS(html);
		var title = $("#titleContent").val();
		var imgUrl = $("#coverImg")[0].currentSrc;
		var params = {
			contentHtml : filterHtml,
			contentText : text,
			title : title
		};
		if (imgUrl != null && imgUrl != undefined && imgUrl !="") {
			debugger;
			imgUrl = imgUrl.substring(domainName.length);
			if (imgUrl.indexOf("icon-add.png") <= 0) {
				params.coverImageUrl = imgUrl;
			}
		}
		layer.load(0,{shade: 0.3});
		setTimeout(function(){
			  layer.closeAll('loading');
			  layer.alert("发布超时,请到'文章管理'查看是否发布成功",{
					icon : 1,
					title : "提示"
				});
			}, 60000);
		$.post("/note/userCenter/submitContent", params, function(data) {
			if (data.code == 200) {
				layer.closeAll('loading');
				layer.alert("发布成功",{
					icon : 1,
					title : "提示"
				},
				function(){
					location.reload();
				});
			}else if(data.code != 400){
				layer.alert(data.message,{
					icon : 5,
					title : "提示"
				});
			}else{
				layer.alert("发布超时,请到'文章管理'查看是否发布成功",{
					icon : 5,
					title : "提示"
				});
			}
		});
	
	});
	
	//绑定封面图事件
	var editorApp = new Vue({
		el:'#coverApp',
		methods:{
			coverImgClick:function(){
				var imgList = $("#editor img");
				if (imgList	 == null || imgList.length == 0) {
					layer.alert('编写的文章中请加入图片',{
						icon:5,title:"提示"
					});
				}else{
					var imgHtmls = ['<div sytel="width:100%;height:100%;"><ul class="imglist">'];
					imgList.each(function(){
						var imgUrl = $(this)[0].currentSrc;
						if (imgUrl != null && imgUrl != undefined && imgUrl != "") {
							var imgHtml = "<li onclick='selectImg(this)'><img src="+imgUrl+" /></li>";
							imgHtmls.push(imgHtml);
						}
					});
					imgHtmls.push('</ul></div>');
					layer.open({
						  title:'请选择封面图',
						  type: 1,
						  skin: 'layui-layer-rim', //加上边框
						  area: ['600px', '500px'], //宽高
						  content: imgHtmls.join('')
						});
				}
				
			}
		}
	});
}

var selectImg = function(t){
	$(t).find('img').each(function(){
		var imgUrl = $(this)[0].currentSrc;
		$("#coverApp").find('img').each(function(){
			$("#coverImg").attr('src',imgUrl);
		});
		layer.closeAll();
	});
}