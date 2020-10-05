<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>${param.title}</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
<body>
	<jsp:include page="jsp/header.jsp"/>

	
	<h1>${param.title}</h1>

	<jsp:include page="${param.content}.jsp"/>
	
	<jsp:include page="jsp/footer.jsp"/>
	
	
</body>
</html>