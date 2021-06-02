<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title><tiles:insertAttribute name="title"/></title>
	<link rel="icon" href="data:;base64,iVBORw0KGgo=">
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jquery/css/smoothness/jquery-ui.min.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap4/css/bootstrap-icons.css" type="text/css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Actor">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Adamina">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Alegreya">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Aleo">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Alike">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Dela+Gothic+One">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/simple-line-icons.min.css" type="text/css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Login-Form-Dark.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/vanilla-zoom.min.css" type="text/css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery/js/jquery.min.js"></script>
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/vanilla-zoom.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/theme.js"></script>
	<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	
</head>

<body>
	<header class="header">
		<tiles:insertAttribute name="header"/>
	</header>
	
   <main class="container">
   	 	<tiles:insertAttribute name="body"/>
   </main>
    
    <footer>
    	<tiles:insertAttribute name="footer"/>
    </footer>
    
   	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/popper.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/vanilla-zoom.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/theme.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery/js/jquery.ui.datepicker-ko.js"></script>
</body>
</html>