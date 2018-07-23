var base_localObj;
var base_contextPath;
var base_path;
var base_serverContext;
var domainName;
$(document).ready(function() {
	localObj = window.location;
	contextPath = localObj.pathname.split("/")[1];
	domainName = localObj.protocol+"//"+localObj.host;
	basePath = domainName +"/" + contextPath;
	base_serverContext=basePath;
});
