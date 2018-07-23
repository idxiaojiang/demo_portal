$(function() {
	var localObj = window.location;
	var contextPath = localObj.pathname.split("/")[1];
	var basePath = localObj.protocol + "//" + localObj.host + "/" + contextPath;
	var server_context = basePath;

	var initPage = function() {
		initEvent();
		initPage();
	}

})

var initEvent = function() {
	$("#publish").bind('click', function() {
		window.open(server_context + "/userCenter/publish");
	});
}

var initPage = function(){
	
}
