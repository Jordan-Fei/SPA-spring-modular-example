<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<%@ page import="com.jfi.myEnterpriseApp.PageResourceLoader,java.util.List" %>
<!DOCTYPE html>
<html data-ng-app="myEnterpriseApp">
<head>
<script type='text/javascript' src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
<script type='text/javascript' src="${pageContext.servletContext.contextPath}/resources/js/angular.js"></script>
<script type='text/javascript' src="${pageContext.servletContext.contextPath}/resources/js/angular-route.js"></script>
<script type='text/javascript' src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.js"></script>
<script type='text/javascript' src="${pageContext.servletContext.contextPath}/resources/js/ui-bootstrap-tpls-0.11.0.js"></script>
<script type='text/javascript' src="${pageContext.servletContext.contextPath}/resources/js/script.js"></script>
<script type='text/javascript' src="${pageContext.servletContext.contextPath}/resources/js/ng-grid.js"></script>

<script type='text/javascript' src="${pageContext.servletContext.contextPath}/resources/js/app.js"></script>
<script type='text/javascript' src="${pageContext.servletContext.contextPath}/resources/js/config.js"></script>
<script type='text/javascript' src="${pageContext.servletContext.contextPath}/resources/js/menuController.js"></script>
<script type='text/javascript' src="${pageContext.servletContext.contextPath}/resources/js/menuDirectives.js"></script>
<script type='text/javascript' src="${pageContext.servletContext.contextPath}/resources/js/menuService.js"></script>

<!-- Need to be improved -->
<!--  <script type='text/javascript' src="${pageContext.servletContext.contextPath}/resources/js/soService.js"></script>-->
<!--  <script type='text/javascript' src="${pageContext.servletContext.contextPath}/resources/js/sofindController.js"></script>-->
<!--  <script type='text/javascript' src="${pageContext.servletContext.contextPath}/resources/js/socreateController.js"></script> -->

<!--<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/so_create.css">-->

<!-- Method 1: to load javascript/css references when load page -->
<%
/*
   PageResourceLoader prl = PageResourceLoader.getInstance();
   List<String> jsList = prl.getJavaScriptsList();
   List<String> cssList = prl.getCssList();
   for(String js: jsList){
   %>
	<script type='text/javascript' src="${pageContext.servletContext.contextPath}<%= js%>"></script>
<%    
}
%>

<%
for(String css: cssList){
%>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}<%= css%>"></link>
<%    
}
*/
%>

<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/app_style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/ng-grid.css">
<title>Home</title>
<base href="/myEnterpriseApp/"></base>
</head>
<body>
	<!-- Header -->
	<div class="page-header">
		<h2>
			myEnterpriseApp <small>Modular Web Application</small>
		</h2>
	</div>
	
	<!-- Dynamic Menus -->
	<div data-ng-controller="MenuController" data-ng-init="init()">
	   <ul class="nav nav-pills"><collection collection='menuItems'></collection></ul>
	</div>

	<!-- Fixed Menu 
	<div>
		<ul class="nav nav-pills">
			<li class="active dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> FunctionGroup1 <span
					class="caret"></span>
			</a>
				<ul class="dropdown-menu">
					<li><a href="#">Function1</a></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">FunctionGroup2 <span
					class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">Function2</a></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">FunctionGroup3 <span
					class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">Function3</a></li>
					<li class="divider"></li>
					<li><a href="#">Function4</a></li>
				</ul></li>
		</ul>
	</div>
    --> 

	<!-- PARTIALS -->
	<div class="section">
		<div data-ng-view></div>
	</div>

	<!-- Footer -->
</body>
</html>
